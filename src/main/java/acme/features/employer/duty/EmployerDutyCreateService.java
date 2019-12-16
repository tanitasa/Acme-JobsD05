
package acme.features.employer.duty;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.descriptors.Descriptor;
import acme.entities.duties.Duty;
import acme.entities.roles.Employer;
import acme.features.employer.descriptor.EmployerDescriptorRepository;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractCreateService;

@Service
public class EmployerDutyCreateService implements AbstractCreateService<Employer, Duty> {

	// Internal state ---------------------------

	@Autowired
	EmployerDutyRepository			repository;

	@Autowired
	EmployerDescriptorRepository	repositoryDescriptor;


	@Override
	public boolean authorise(final Request<Duty> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Duty> request, final Duty entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
		Collection<Descriptor> descriptors = this.repositoryDescriptor.findManyAll();
		request.getModel().setAttribute("descriptors", descriptors);
	}

	@Override
	public void unbind(final Request<Duty> request, final Duty entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "percentage", "description");
		Collection<Descriptor> descriptors = this.repositoryDescriptor.findManyAll();
		model.setAttribute("descriptors", descriptors);
	}

	@Override
	public Duty instantiate(final Request<Duty> request) {
		assert request != null;
		Duty result;

		result = new Duty();

		return result;
	}

	@Override
	public void validate(final Request<Duty> request, final Duty entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		boolean esValido = entity.getPercentage() <= 100.00;
		errors.state(request, esValido, "percentage", "employer.duty.error.percentage");

	}

	@Override
	public void create(final Request<Duty> request, final Duty entity) {
		assert request != null;
		assert entity != null;

		String idAux = (String) request.getModel().getAttribute("descriptorId");
		int id = Integer.parseInt(idAux);
		Descriptor descriptor = this.repositoryDescriptor.findOneById(id);
		entity.setDescriptor(descriptor);

		this.repository.save(entity);

		descriptor.getDuties().add(entity);
		this.repositoryDescriptor.save(entity);
	}

}
