
package acme.features.authenticated.offer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.offers.Offer;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedOfferListService implements AbstractListService<Authenticated, Offer> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private AuthenticatedOfferRepository repository;


	// AbstractListService<Authenticated, Request> interface ---------------

	@Override
	public boolean authorise(final Request<Offer> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Offer> request, final Offer entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "ticker", "title", "creationMoment", "deadline", "minReward", "maxReward", "description");
	}

	@Override
	public Collection<Offer> findMany(final Request<Offer> request) {
		assert request != null;
		Collection<Offer> result = new ArrayList<Offer>();
		Collection<Offer> aux;

		aux = this.repository.findManyAll();

		for (Offer a : aux) {
			if (a.getDeadline().after(new Date())) {
				result.add(a);
			}
		}

		return result;
	}

}
