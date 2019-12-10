
package acme.features.authenticated.investorRecord;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.investorRecords.InvestorRecord;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedInvestorRecordRepository extends AbstractRepository {

	@Query("select c from InvestorRecord c where c.id = ?1")
	InvestorRecord findOneById(int id);

	@Query("select c from InvestorRecord c")
	Collection<InvestorRecord> findManyAll();

}
