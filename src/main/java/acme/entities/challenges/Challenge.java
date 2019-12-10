
package acme.entities.challenges;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import acme.framework.datatypes.Money;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Challenge extends DomainEntity {

	// Serialisation identifier -----------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@NotBlank
	private String				title;

	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	private Date				deadline;

	@NotBlank
	private String				description;

	@NotBlank
	private String				goldEn;

	@NotNull
	private Money				rewardGold;

	@NotBlank
	private String				silverEn;

	@NotNull
	private Money				rewardSilver;

	@NotBlank
	private String				bronzeEn;

	@NotNull
	private Money				rewardBronze;

	// Derived attributes -----------------------------------------------------

	// Relationships ----------------------------------------------------------

}
