
package acme.features.anonymous.companyRecord;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.companyRecords.CompanyRecord;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractListService;

@Service
public class AnonymousCompanyRecordListService implements AbstractListService<Anonymous, CompanyRecord> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private AnonymousCompanyRecordRepository repository;


	// AbstractListService<Authenticated, Request> interface ---------------

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

		if (entity.getIsIncorporated().equals(true)) {
			entity.setName(entity.getName() + ",INC");
		} else {
			entity.setName(entity.getName() + ",LLC");
		}

		request.unbind(entity, model, "name", "sector", "ceoName", "description", "web", "phoneNumber", "email", "isIncorporated", "stars");
	}

	@Override
	public Collection<CompanyRecord> findMany(final Request<CompanyRecord> request) {
		assert request != null;
		Collection<CompanyRecord> result;

		result = this.repository.findManyAll();

		return result;
	}

}
