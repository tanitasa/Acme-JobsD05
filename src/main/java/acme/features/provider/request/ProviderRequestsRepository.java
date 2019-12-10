
package acme.features.provider.request;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.requests.Requests;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface ProviderRequestsRepository extends AbstractRepository {

	@Query("select r from Requests r where r.id = ?1")
	Requests findOneById(int id);

	@Query("select r from Requests r")
	Collection<Requests> findManyAll();

}
