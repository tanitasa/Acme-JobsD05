
package acme.features.administrator.investorRecord;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.investorRecords.InvestorRecord;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorInvestorRecordRepository extends AbstractRepository {

	@Query("select c from InvestorRecord c where c.id = ?1")
	InvestorRecord findOneInvestorRecordById(int id);

	@Query("Select c from InvestorRecord c")
	Collection<InvestorRecord> findManyInvestorRecords();

	@Query("select c from InvestorRecord c")
	Collection<InvestorRecord> findManyAll();

}
