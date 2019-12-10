
package acme.entities.jobs;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.entities.applications.Application;
import acme.entities.descriptors.Descriptor;
import acme.entities.roles.Employer;
import acme.framework.datatypes.Money;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Job extends DomainEntity {

	// Serialisation identifier -----------------------------------------------

	private static final long		serialVersionUID	= 1L;

	//Attributes ----------------------------------------------------------
	@NotBlank
	@Length(min = 5, max = 10)
	private String					reference;

	@NotBlank
	private String					title;

	@NotBlank
	@Pattern(regexp = "^draft|published|borrador|publicado$")
	private String					status;

	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	private Date					deadline;

	@NotNull
	@Valid
	private Money					salary;

	@URL
	private String					link;

	private Boolean					isActive;

	//Relationships ----------------------------------------------------------
	@Valid
	@OneToOne
	private Descriptor				descriptor;

	@Valid
	@ManyToOne(optional = false)
	private Employer				employer;

	@Valid
	@OneToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	private Collection<Application>	applications;
}
