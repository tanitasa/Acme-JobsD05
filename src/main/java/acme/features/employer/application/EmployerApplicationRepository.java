
package acme.features.employer.application;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.applications.Application;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface EmployerApplicationRepository extends AbstractRepository {

	@Query("select a from Application a where a.id = ?1")
	Application findOneById(int id);

	@Query("select a from Application a")
	Collection<Application> findManyAll();

	@Query("select a from Application a where a.job.employer.id = ?1")
	Collection<Application> findManyAllByEmployer(int employerId);

	@Query("select a from Application a where a.job.employer.id = ?1 group by a.reference")
	Collection<Application> findManyByReference(int employerId);

	@Query("select a from Application a where a.job.employer.id = ?1 group by a.status")
	Collection<Application> findManyByStatus(int employerId);

	@Query("select a from Application a where a.job.employer.id = ?1 group by a.creationMoment")
	Collection<Application> findManyByCreationMoment(int employerId);

}
