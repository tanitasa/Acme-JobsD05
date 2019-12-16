
package acme.features.employer.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.applications.Application;
import acme.entities.roles.Employer;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractShowService;

@Service
public class EmployerApplicationShowService implements AbstractShowService<Employer, Application> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private EmployerApplicationRepository repository;


	// AbstractShowService<Authenticated, Challenge> interface ---------------

	@Override
	public boolean authorise(final Request<Application> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Application> request, final Application entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "reference", "creationMoment", "statement", "status", "qualifications", "skills", "job.title", "justification");
	}

	@Override
	public Application findOne(final Request<Application> application) {
		assert application != null;

		Application result;
		int id;

		id = application.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;
	}

}
