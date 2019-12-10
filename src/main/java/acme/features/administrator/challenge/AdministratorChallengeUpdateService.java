
package acme.features.administrator.challenge;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.challenges.Challenge;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractUpdateService;

@Service
public class AdministratorChallengeUpdateService implements AbstractUpdateService<Administrator, Challenge> {

	//InternalState
	@Autowired
	AdministratorChallengeRepository repository;


	@Override
	public boolean authorise(final Request<Challenge> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Challenge> request, final Challenge entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<Challenge> request, final Challenge entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "deadline", "description", "goldEn", "rewardGold", "silverEn", "rewardSilver", "bronzeEn", "rewardBronze");

	}

	@Override
	public Challenge findOne(final Request<Challenge> request) {
		assert request != null;
		Challenge result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneChallengeById(id);

		return result;
	}

	@Override
	public void validate(final Request<Challenge> request, final Challenge entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		if (null != entity.getDeadline() && entity.getDeadline().before(new Date(System.currentTimeMillis() - 1))) {
			errors.add("deadline", "Must be in the future");
		}

		if (null != entity.getRewardGold() && null != entity.getRewardSilver() && null != entity.getRewardBronze() && null != entity.getRewardGold().getAmount() && null != entity.getRewardSilver().getAmount() && null != entity.getRewardBronze().getAmount()
			&& (entity.getRewardGold().getAmount() < entity.getRewardSilver().getAmount() || entity.getRewardGold().getAmount() < entity.getRewardBronze().getAmount() || entity.getRewardSilver().getAmount() < entity.getRewardBronze().getAmount())) {
			errors.add("rewardGold", "Gold must be higher than silver, silver must be higher than bronze");
			errors.add("rewardSilver", "Gold must be higher than silver, silver must be higher than bronze");
			errors.add("rewardBronze", "Gold must be higher than silver, silver must be higher than bronze");
		}
	}

	@Override
	public void update(final Request<Challenge> request, final Challenge entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);

	}

}
