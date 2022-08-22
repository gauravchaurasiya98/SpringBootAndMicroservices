package in.gaurav.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CONTACT_NUMBERS_OTM")
public class ContactNumbers implements Serializable {
	@Id
	private Long number;
	@Column(length = 10)
	private String numberType;
	@Column(length = 10)
	private String operator;
}
