
package acme.features.employer.job;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.duties.Duty;
import acme.entities.jobs.Job;
import acme.entities.roles.Employer;
import acme.features.employer.descriptor.EmployerDescriptorRepository;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractUpdateService;

@Service
public class EmployerJobUpdateService implements AbstractUpdateService<Employer, Job> {

	//InternalState
	@Autowired
	EmployerJobRepository			repository;

	@Autowired
	EmployerDescriptorRepository	descriptorRepository;


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
		Job oldJob = this.repository.findOneById(entity.getId());

		if (entity.getStatus() != null) { //No se puede modificar si está en modo published
			boolean esValido = oldJob.getStatus().equals("draft");
			errors.state(request, esValido, "status", "employer.job.error.status.esValido"); //errors.state salta si no se cumple esValido
		}

		if (entity.getDescriptor() == null && entity.getStatus() != null) {
			boolean esValido = entity.getDescriptor() != null || entity.getStatus().equals("draft");
			errors.state(request, esValido, "status", "employer.job.error.descriptor.tieneDescriptor");
		}

		if (entity.getDescriptor() != null && entity.getStatus() != null) {
			for (Duty d : entity.getDescriptor().getDuties()) {
				suma = suma + d.getPercentage();
			}
			boolean esValido = suma == 100.0 || entity.getStatus().equals("draft");
			errors.state(request, esValido, "status", "employer.job.error.descriptor.mayorQue100");
		}

		if (entity.getDeadline() != null) {
			Calendar calendar = new GregorianCalendar();
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			Date minimunDeadLine = calendar.getTime();
			boolean esValido = entity.getDeadline().after(minimunDeadLine);
			errors.state(request, esValido, "deadline", "employer.job.error.deadline");
		}

		//TODO 3º condicion de SPAM.

	}

	@Override
	public void update(final Request<Job> request, final Job entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);

	}

}
