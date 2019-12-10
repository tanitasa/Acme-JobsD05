
package acme.features.authenticated.request;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.requests.Requests;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedRequestsListService implements AbstractListService<Authenticated, Requests> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private AuthenticatedRequestsRepository repository;


	// AbstractListService<Authenticated, Request> interface ---------------

	@Override
	public boolean authorise(final Request<Requests> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Requests> request, final Requests entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "ticker", "title", "creationMoment", "deadline", "reward", "description");
	}

	@Override
	public Collection<Requests> findMany(final Request<Requests> request) {
		assert request != null;
		Collection<Requests> result = new ArrayList<Requests>();
		Collection<Requests> aux;

		aux = this.repository.findManyAll();

		for (Requests a : aux) {
			if (a.getDeadline().after(new Date())) {
				result.add(a);
			}
		}

		return result;
	}

}
