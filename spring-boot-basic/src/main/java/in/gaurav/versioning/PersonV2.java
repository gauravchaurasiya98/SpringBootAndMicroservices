package in.gaurav.versioning;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class PersonV2 {

    private Name name;

    @Getter
    @Setter
    @ToString
    @AllArgsConstructor
    public static class Name {
        private String firstName;
        private String lastName;
    }
}
