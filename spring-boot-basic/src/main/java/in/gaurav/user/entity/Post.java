package in.gaurav.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
//@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Post {
    //@EqualsAndHashCode.Include
    @Id
    @GeneratedValue(generator = "postIdGenerator")
    @SequenceGenerator(name = "postIdGenerator", sequenceName = "post_id_seq", initialValue = 1001, allocationSize = 20)
    private Integer id;
    @NotBlank(message = "Description should not be empty/blank")
    @Size(min = 10, message = "Description should must contains minimum 10 characters")
    private String description;
    @JsonIgnore
    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    private User user;
}
