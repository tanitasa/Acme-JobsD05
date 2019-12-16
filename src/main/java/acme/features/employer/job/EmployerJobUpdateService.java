
package acme.features.employer.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.duties.Duty;
import acme.entities.jobs.Job;
import acme.entities.roles.Employer;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractUpdateService;

@Service
public class EmployerJobUpdateService implements AbstractUpdateService<Employer, Job> {

	//InternalState
	@Autowired
	EmployerJobRepository repository;


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
		//result = job.getIsActive() || !job.getIsActive() && employer.getUserAccount().getId() == principal.getAccountId();
		result = job.getStatus().equals("publicado") || job.getStatus().equals("published") || !(job.getStatus().equals("publicado") || job.getStatus().equals("published")) && employer.getUserAccount().getId() == principal.getAccountId();

		return result;
	}

	@Override
	public void bind(final Request<Job> request, final Job entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<Job> request, final Job entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "reference", "title", "status", "deadline", "salary", "link");

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

	@Override
	public void validate(final Request<Job> request, final Job entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		Double suma = 0.0;

		if (entity.getStatus() != null) { //No se puede modificar si está en modo published
			boolean esFinal = entity.getStatus().equals("draft");
			errors.state(request, esFinal, "status", "employer.job.error.status.esFinal"); //errors.state salta si no se cumple esFinal
		}

		if (entity.getDescriptor() != null) {
			boolean esFinal = entity.getDescriptor() != null;
			errors.state(request, esFinal, "descriptor", "employer.job.error.descriptor.tieneDescriptor");
		}

		//		if (!errors.hasErrors("descriptor")) {
		//			boolean tieneDescriptor = entity.getDescriptor() == null;
		//			errors.state(request, tieneDescriptor, "descriptor", "employer.job.error.descriptor.tieneDescriptor");
		//		}

		if (entity.getDescriptor() != null) {
			for (Duty d : entity.getDescriptor().getDuties()) {
				suma = suma + d.getPercentage();
			}
			boolean esFinal = suma == 100.0;
			errors.state(request, esFinal, "descriptor", "employer.job.error.descriptor.mayorQue100");
		}

		//Mirar 3º condicion de SPAM.

	}

	@Override
	public void update(final Request<Job> request, final Job entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);

	}

}
