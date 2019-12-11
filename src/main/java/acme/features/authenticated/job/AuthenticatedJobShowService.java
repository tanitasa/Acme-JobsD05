
package acme.features.authenticated.job;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.applications.Application;
import acme.entities.descriptors.Descriptor;
import acme.entities.duties.Duty;
import acme.entities.jobs.Job;
import acme.entities.roles.Employer;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractShowService;

@Service
public class AuthenticatedJobShowService implements AbstractShowService<Authenticated, Job> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private AuthenticatedJobRepository repository;


	// AbstractShowService<Authenticated, Challenge> interface ---------------

	@Override
	public boolean authorise(final Request<Job> request) {
		assert request != null;

		int id = request.getModel().getInteger("id");
		Job job = this.repository.findOneById(id);

		return job.getIsActive();
	}

	@Override
	public void unbind(final Request<Job> request, final Job entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		Descriptor descriptor = entity.getDescriptor();
		Collection<Duty> duties = descriptor.getDuties();
		Employer employer = entity.getEmployer();
		Collection<Application> applications = entity.getApplications();

		request.unbind(entity, model, "reference", "title", "status", "deadline", "salary", "link", "isActive", "descriptor", "employer", "applications");

		model.setAttribute("descriptor", descriptor.getDescription());
		model.setAttribute("employer", employer.getCompany());
		model.setAttribute("applications", applications);
		model.setAttribute("duties", duties);
	}

	@Override
	public Job findOne(final Request<Job> job) {
		assert job != null;

		Job result;
		int id;

		id = job.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;
	}

}
