
package acme.features.provider.request;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.requests.Requests;
import acme.entities.roles.Provider;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractCreateService;

@Service
public class ProviderRequestsCreateService implements AbstractCreateService<Provider, Requests> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private ProviderRequestsRepository repository;


	// AbstractCreateService<Provider, Requests> interface ---------------

	@Override
	public boolean authorise(final Request<Requests> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Requests> request, final Requests entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "creationMoment");
	}

	@Override
	public void unbind(final Request<Requests> request, final Requests entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "ticker", "title", "deadline", "reward", "description");
	}

	@Override
	public Requests instantiate(final Request<Requests> request) {
		Requests result;

		result = new Requests();

		return result;
	}

	@Override
	public void validate(final Request<Requests> request, final Requests entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		if (null != entity.getDeadline() && entity.getDeadline().before(new Date(System.currentTimeMillis() - 1))) {
			errors.add("deadline", "Must be in the future");
		}

		if (null != entity.getTicker()) {
			for (Requests r : this.repository.findManyAll()) {
				if (r.getTicker().equals(entity.getTicker())) {
					errors.add("ticker", "Already exist");
					break;
				}
			}
		}
	}

	@Override
	public void create(final Request<Requests> request, final Requests entity) {
		Date creationMoment = new Date(System.currentTimeMillis() - 1);
		entity.setCreationMoment(creationMoment);
		this.repository.save(entity);
	}

}
