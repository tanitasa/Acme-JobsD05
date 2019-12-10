
package acme.features.administrator.companyRecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.companyRecords.CompanyRecord;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractCreateService;

@Service
public class AdministratorCompanyRecordCreateService implements AbstractCreateService<Administrator, CompanyRecord> {

	//InternalState
	@Autowired
	AdministratorCompanyRecordRepository repository;


	@Override
	public boolean authorise(final Request<CompanyRecord> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<CompanyRecord> request, final CompanyRecord entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);

	}

	@Override
	public void unbind(final Request<CompanyRecord> request, final CompanyRecord entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "name", "sector", "ceoName", "description", "web", "phoneNumber", "email", "isIncorporated", "stars");

	}

	@Override
	public CompanyRecord instantiate(final Request<CompanyRecord> request) {
		CompanyRecord result;

		result = new CompanyRecord();

		return result;
	}

	@Override
	public void validate(final Request<CompanyRecord> request, final CompanyRecord entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void create(final Request<CompanyRecord> request, final CompanyRecord entity) {
		assert request != null;
		assert entity != null;

		if (entity.getIsIncorporated().equals(true)) {
			entity.setName(entity.getName() + ",INC");
		} else {
			entity.setName(entity.getName() + ",LLC");
		}

		this.repository.save(entity);

	}

}
