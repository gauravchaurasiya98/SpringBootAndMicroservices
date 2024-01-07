package in.gaurav.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "CONTACT_NUMBER_OTM")
public class ContactNumber implements Serializable {
	@Id
    @EqualsAndHashCode.Include
	private Long number;
	@Column(length = 10)
	private String numberType;
	@Column(length = 10)
	private String operator;

	@ManyToOne(targetEntity = Person.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "PERSON_ID", referencedColumnName = "personId")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Person person;
}
