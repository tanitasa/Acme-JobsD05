
package acme.features.employer.job;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.descriptors.Descriptor;
import acme.entities.jobs.Job;
import acme.entities.roles.Employer;
import acme.features.authenticated.employer.AuthenticatedEmployerRepository;
import acme.features.employer.descriptor.EmployerDescriptorRepository;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractCreateService;

@Service
public class EmployerJobCreateService implements AbstractCreateService<Employer, Job> {

	//InternalState
	@Autowired
	EmployerJobRepository			repository;

	@Autowired
	AuthenticatedEmployerRepository	employerRepository;

	@Autowired
	EmployerDescriptorRepository	descriptorRepository;


	@Override
	public boolean authorise(final Request<Job> request) {
		assert request != null;

		return true;
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

		request.unbind(entity, model, "reference", "title", "status", "deadline", "salary", "link", "employer");
		Collection<Descriptor> descriptors = this.repository.findAllDescriptors();
		model.setAttribute("descriptors", descriptors);

		Employer employer = this.repository.findEmployerById(request.getPrincipal().getActiveRoleId());
		model.setAttribute("employer", employer);
	}

	@Override
	public Job instantiate(final Request<Job> request) {
		Job result;

		result = new Job();
		result.setStatus("draft");

		return result;
	}

	@Override
	public void validate(final Request<Job> request, final Job entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void create(final Request<Job> request, final Job entity) {
		assert request != null;
		assert entity != null;

		Employer principal;
		principal = (Employer) this.employerRepository.findById(request.getPrincipal().getActiveRoleId()).orElse(null);
		assert principal != null;
		entity.setEmployer(principal);

		String idAux = (String) request.getModel().getAttribute("descriptorId");
		int id = Integer.parseInt(idAux);
		Descriptor descriptor = this.descriptorRepository.findOneById(id);
		entity.setDescriptor(descriptor);

		this.repository.save(entity);

	}

}
