
package acme.features.authenticated.challenge;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.challenges.Challenge;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedChallengeListService implements AbstractListService<Authenticated, Challenge> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private AuthenticatedChallengeRepository repository;


	// AbstractListService<Authenticated, Challenge> interface ---------------

	@Override
	public boolean authorise(final Request<Challenge> challenge) {
		assert challenge != null;

		return true;
	}

	@Override
	public void unbind(final Request<Challenge> challenge, final Challenge entity, final Model model) {
		assert challenge != null;
		assert entity != null;
		assert model != null;
		challenge.unbind(entity, model, "title", "deadline", "description", "goldEn", "rewardGold", "silverEn", "rewardSilver", "bronzeEn", "rewardBronze");

	}

	@Override
	public Collection<Challenge> findMany(final Request<Challenge> request) {
		assert request != null;
		Collection<Challenge> result = new ArrayList<Challenge>();
		Collection<Challenge> aux;

		aux = this.repository.findManyAll();

		for (Challenge a : aux) {
			if (a.getDeadline().after(new Date())) {
				result.add(a);
			}
		}

		return result;
	}

}
