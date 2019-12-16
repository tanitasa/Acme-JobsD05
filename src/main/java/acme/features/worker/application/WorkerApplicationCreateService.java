
package acme.features.worker.application;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.applications.Application;
import acme.entities.jobs.Job;
import acme.entities.roles.Worker;
import acme.features.authenticated.worker.AuthenticatedWorkerRepository;
import acme.features.employer.job.EmployerJobRepository;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractCreateService;

@Service
public class WorkerApplicationCreateService implements AbstractCreateService<Worker, Application> {

	//InternalState
	@Autowired
	WorkerApplicationRepository		repository;

	@Autowired
	AuthenticatedWorkerRepository	workerRepository;

	@Autowired
	EmployerJobRepository			jobRepository;


	@Override
	public boolean authorise(final Request<Application> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Application> request, final Application entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
		//TODO restriccioes: Apply for a job as long as it’s
		//been published and its deadline hasn’t elapsed.
		Collection<Job> jobs = this.jobRepository.findManyAll();
		request.getModel().setAttribute("jobs", jobs);

	}

	@Override
	public void unbind(final Request<Application> request, final Application entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "reference", "creationMoment", "status", "statement", "qualifications", "skills", "worker");
		Collection<Job> jobs = this.jobRepository.findManyAll();
		model.setAttribute("jobs", jobs);

		Worker worker = this.repository.findWorkerById(request.getPrincipal().getActiveRoleId());
		model.setAttribute("worker", worker);
	}

	@Override
	public Application instantiate(final Request<Application> request) {
		Application result;

		result = new Application();

		Calendar calendar = new GregorianCalendar();
		calendar.add(Calendar.MILLISECOND, 1);
		Date today = calendar.getTime();

		result.setStatus("pending");
		result.setCreationMoment(today);

		return result;
	}

	@Override
	public void validate(final Request<Application> request, final Application entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void create(final Request<Application> request, final Application entity) {
		assert request != null;
		assert entity != null;

		Worker principal;
		principal = (Worker) this.workerRepository.findById(request.getPrincipal().getActiveRoleId()).orElse(null);
		assert principal != null;
		entity.setWorker(principal);

		String idAux = (String) request.getModel().getAttribute("jobId");
		int id = Integer.parseInt(idAux);
		Job job = this.jobRepository.findOneById(id);
		entity.setJob(job);

		this.repository.save(entity);

		job.getApplications().add(entity);
		this.jobRepository.save(job);
	}

}
