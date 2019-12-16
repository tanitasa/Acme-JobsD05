
package acme.entities.applications;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import acme.entities.jobs.Job;
import acme.entities.roles.Worker;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Application extends DomainEntity {

	// Serialisation identifier -----------------------------------------------

	private static final long	serialVersionUID	= 1L;

	//Attributes ----------------------------------------------------------
	@NotBlank
	@Length(min = 5, max = 15)
	private String				reference;

	@Temporal(TemporalType.TIMESTAMP)
	@Past
	private Date				creationMoment;

	@NotBlank
	private String				statement;

	@NotBlank
	@Pattern(regexp = "^pending|accepted|reject|pendiente|aceptada|rechazada$")
	private String				status;

	@NotBlank
	private String				qualifications;

	@NotBlank
	private String				skills;

	private String				justification;

	//Relationships ----------------------------------------------------------
	@Valid
	@ManyToOne(optional = false)
	private Job					job;

	@Valid
	@ManyToOne(optional = false)
	private Worker				worker;
}
