
package acme.features.employer.job;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.descriptors.Descriptor;
import acme.entities.jobs.Job;
import acme.entities.roles.Employer;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;

@Service
public class EmployerJobShowService implements AbstractShowService<Employer, Job> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private EmployerJobRepository repository;


	// AbstractShowService<Authenticated, Challenge> interface ---------------

	@Override
	public boolean authorise(final Request<Job> request) {
		assert request != null;

		boolean result = true;
		int jobId;

		Job job;
		Employer employer;
		Principal principal;

		jobId = request.getModel().getInteger("id");
		job = this.repository.findOneById(jobId);
		employer = job.getEmployer();
		principal = request.getPrincipal();
		result = job.getStatus().equals("publicado") || job.getStatus().equals("published") || !(job.getStatus().equals("publicado") || job.getStatus().equals("published")) && employer.getUserAccount().getId() == principal.getAccountId();

		return result;

	}

	@Override
	public void unbind(final Request<Job> request, final Job entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		Collection<Descriptor> descriptors = this.repository.findAllDescriptors();

		request.unbind(entity, model, "reference", "title", "status", "deadline", "salary", "link");
		model.setAttribute("descriptors", descriptors);
		if (null != entity.getDescriptor()) {
			String descriptionDescriptor = entity.getDescriptor().getDescription();
			model.setAttribute("descriptor", descriptionDescriptor);
		} else {
			model.setAttribute("descriptor", "");
		}
	}

	@Override
	public Job findOne(final Request<Job> request) {
		assert request != null;

		Job result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;
	}

}
