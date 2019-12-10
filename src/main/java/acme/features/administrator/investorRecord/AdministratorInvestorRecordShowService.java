
package acme.features.administrator.investorRecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.investorRecords.InvestorRecord;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorInvestorRecordShowService implements AbstractShowService<Administrator, InvestorRecord> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private AdministratorInvestorRecordRepository repository;


	// AbstractShowService<Authenticated, CompanyRecord> interface ---------------

	@Override
	public boolean authorise(final Request<InvestorRecord> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<InvestorRecord> request, final InvestorRecord entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "name", "sector", "investingStatement", "stars");

	}

	@Override
	public InvestorRecord findOne(final Request<InvestorRecord> investorRecord) {
		assert investorRecord != null;

		InvestorRecord result;
		int id;

		id = investorRecord.getModel().getInteger("id");
		result = this.repository.findOneInvestorRecordById(id);

		return result;
	}

}
