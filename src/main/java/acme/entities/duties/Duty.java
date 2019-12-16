
package acme.entities.duties;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import acme.entities.descriptors.Descriptor;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Duty extends DomainEntity {

	// Serialisation identifier -----------------------------------------------

	private static final long	serialVersionUID	= 1L;

	//Attributes ----------------------------------------------------------
	@NotBlank
	private String				title;

	@NotBlank
	private String				description;

	@NotNull
	private double				percentage;

	//Relationships ----------------------------------------------------------
	@Valid
	@ManyToOne(optional = false)
	private Descriptor			descriptor;
}
