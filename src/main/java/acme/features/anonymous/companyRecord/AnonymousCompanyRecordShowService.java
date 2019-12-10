
package acme.features.anonymous.companyRecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.companyRecords.CompanyRecord;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractShowService;

@Service
public class AnonymousCompanyRecordShowService implements AbstractShowService<Anonymous, CompanyRecord> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private AnonymousCompanyRecordRepository repository;


	// AbstractShowService<Authenticated, Challenge> interface ---------------

	@Override
	public boolean authorise(final Request<CompanyRecord> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<CompanyRecord> request, final CompanyRecord entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "name", "sector", "ceoName", "description", "web", "phoneNumber", "email", "isIncorporated", "stars");

	}

	@Override
	public CompanyRecord findOne(final Request<CompanyRecord> companyRecord) {
		assert companyRecord != null;

		CompanyRecord result;
		int id;

		id = companyRecord.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;
	}

}
