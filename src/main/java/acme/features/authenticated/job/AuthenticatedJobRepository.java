
package acme.features.authenticated.job;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.jobs.Job;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedJobRepository extends AbstractRepository {

	@Query("select c from Job c where c.id = ?1")
	Job findOneById(int id);

	@Query("select c from Job c")
	Collection<Job> findManyAll();

	@Query("select c from Job c where c.isActive = true")
	Collection<Job> findManyAllActives();

}
