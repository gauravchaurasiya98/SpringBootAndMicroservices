package in.gaurav.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@JsonFilter("DummyFilter")
// @JsonIgnoreProperties("field3")
public class DummyBean {
    // @JsonIgnore
    private String field1;
    private String field2;
    private String field3;
}
