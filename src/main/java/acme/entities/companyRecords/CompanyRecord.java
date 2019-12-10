
package acme.entities.companyRecords;

import javax.persistence.Entity;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.URL;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CompanyRecord extends DomainEntity {

	// Serialisation identifier -----------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	//Following : OXXXX-99999

	@NotBlank
	private String				name;

	@NotBlank
	private String				sector;

	@NotBlank
	private String				ceoName;

	@NotBlank
	private String				description;

	@NotBlank
	@URL
	private String				web;

	@NotBlank
	@Pattern(regexp = "^[+][1-9]\\d{0,2}[ ][(][1-9]\\d{0,3}[)][ ]\\d{6,10}$")
	private String				phoneNumber;

	@NotBlank
	@Pattern(regexp = "^[a-zA-Z0-9 ]*[<]?\\w+[@][a-zA-Z0-9.]+[>]?$")
	private String				email;

	private Boolean				isIncorporated;

	@Min(0)
	@Max(5)
	private Integer				stars;

	// Derived attributes -----------------------------------------------------

	// Relationships ----------------------------------------------------------

}
