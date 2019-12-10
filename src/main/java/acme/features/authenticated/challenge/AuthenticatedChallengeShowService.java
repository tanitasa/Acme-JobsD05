
package acme.features.authenticated.challenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.challenges.Challenge;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractShowService;

@Service
public class AuthenticatedChallengeShowService implements AbstractShowService<Authenticated, Challenge> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private AuthenticatedChallengeRepository repository;


	// AbstractShowService<Authenticated, Challenge> interface ---------------

	@Override
	public boolean authorise(final Request<Challenge> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Challenge> request, final Challenge entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		request.unbind(entity, model, "title", "deadline", "description", "goldEn", "rewardGold", "silverEn", "rewardSilver", "bronzeEn", "rewardBronze");
	}

	@Override
	public Challenge findOne(final Request<Challenge> challenge) {
		assert challenge != null;

		Challenge result;
		int id;

		id = challenge.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;
	}

}
