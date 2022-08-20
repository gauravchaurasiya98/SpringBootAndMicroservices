package in.gaurav.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@Entity
public class Student {

	@Id
	@GeneratedValue(generator = "SID_GENERATOR", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SID_GENERATOR", sequenceName = "STUDENT_SID_SEQUENCE", initialValue = 101, allocationSize = 1)
	@Column(name = "s_id")
	private Integer sid;
	@NonNull
	@Column(name = "s_name", length = 20, nullable = false)
	private String sname;
	@NonNull
	@Column(name = "s_age")
	private Byte sage;
	@NonNull
	@Column(name = "s_gender")
	private Character sgender;
	@NonNull
	@Column(name = "s_addr")
	private String saddr;

}
