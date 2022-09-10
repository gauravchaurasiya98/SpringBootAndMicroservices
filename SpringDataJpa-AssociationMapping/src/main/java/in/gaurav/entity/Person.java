package in.gaurav.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PERSON_OTM")
public class Person implements Serializable {
    @Id
    @GeneratedValue(generator = "PERSON_ID_GENERATOR", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "PERSON_ID_GENERATOR", sequenceName = "PERSON_OTM_PERSON_ID_SEQUENCE", initialValue = 101, allocationSize = 1)
    private Integer personId;
    @Column(length = 20)
    private String personName;
    @Column(length = 20)
    private String personAddress;

    @OneToMany(targetEntity = ContactNumber.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "person")
    private Set<ContactNumber> contactNumberSet;

    public void setContactNumberSet(Set<ContactNumber> contactNumberSet) {
        this.contactNumberSet = contactNumberSet;
        contactNumberSet.forEach(contactNumber -> contactNumber.setPerson(this));
    }
}
