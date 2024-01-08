package in.gaurav.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
//@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity(name = "user_details")
public class User {
    //@EqualsAndHashCode.Include
    @Id
    @GeneratedValue(generator = "userIdGenerator")
    @SequenceGenerator(name = "userIdGenerator", sequenceName = "user_id_seq", initialValue = 101, allocationSize = 1)
    private Integer id;
    @NotBlank(message = "Name should not be empty/blank")
    @Size(min = 3, max = 20, message = "Name should must contains b/w 3-20 characters")
    private String name;
    @NotNull(message = "Birth date can't be null")
    @Past(message = "Birth date must be in past")
    private LocalDate birthDate;
    @JsonIgnore
    @OneToMany(targetEntity = Post.class, mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Post> posts;
}
