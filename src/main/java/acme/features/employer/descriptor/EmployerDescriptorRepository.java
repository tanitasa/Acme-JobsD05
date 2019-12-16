
package acme.features.employer.descriptor;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.descriptors.Descriptor;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface EmployerDescriptorRepository extends AbstractRepository {

	@Query("Select d from Descriptor d where d.id = ?1")
	Descriptor findOneById(int id);

	@Query("select d from Descriptor d")
	Collection<Descriptor> findManyAll();

	@Query("select j.descriptor from Job j where j.id =?1")
	Descriptor findOnebyJobId(int id);

}
