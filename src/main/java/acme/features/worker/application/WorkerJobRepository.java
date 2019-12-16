
package acme.features.worker.application;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.applications.Application;
import acme.entities.descriptors.Descriptor;
import acme.entities.jobs.Job;
import acme.entities.roles.Employer;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface WorkerJobRepository extends AbstractRepository {

	@Query("Select j from Job j where j.id = ?1")
	Job findOneById(int id);

	@Query("Select j from Job j where j.employer.id = ?1")
	Collection<Job> findManyAllByEmployer(int jobId);

	@Query("select j from Job j")
	Collection<Job> findManyAll();

	@Query("select d from Descriptor d")
	Collection<Descriptor> findAllDescriptors();

	@Query("select e from Employer e where e.id = ?1")
	Employer findEmployerById(int id);

	@Query("select a from Application a where a.job.id = ?1")
	Collection<Application> findApplicationsByJobId(int id);

	@Query("select j from Job j where j.status = 'published'")
	Collection<Job> findJobForApplication();

}
