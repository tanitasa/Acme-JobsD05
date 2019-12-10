
package acme.entities.descriptors;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import acme.entities.duties.Duty;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Descriptor extends DomainEntity {

	// Serialisation identifier -----------------------------------------------

	private static final long serialVersionUID = 1L;

	//Attributes ----------------------------------------------------------
	@NotBlank
	private String description;

	//Relationships ----------------------------------------------------------
	@Valid
	@OneToMany(fetch = FetchType.EAGER)
	@NotEmpty
	private Collection<Duty> duties;

}
