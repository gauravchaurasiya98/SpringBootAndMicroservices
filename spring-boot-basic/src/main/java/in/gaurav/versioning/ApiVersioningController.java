package in.gaurav.versioning;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api-versioning")
public class ApiVersioningController {
    /*
     * URI Versioning
     * Request Param Versioning
     * Header Versioning
     * Content Negotiation Versioning
     * */

    @GetMapping("/v1/person")
    public ResponseEntity<PersonV1> getFirstVersionOfPersonUsingUri() {
        return ResponseEntity.ok(new PersonV1("Gaurav Chaurasiya"));
    }

    @GetMapping("/v2/person")
    public ResponseEntity<PersonV2> getSecondVersionOfPersonUsingUri() {
        return ResponseEntity.ok(new PersonV2(new PersonV2.Name("Gaurav", "Chaurasiya")));
    }

    @GetMapping(value = "/person", params = "version=1")
    public ResponseEntity<PersonV1> getFirstVersionOfPersonUsingRequestParam() {
        return ResponseEntity.ok(new PersonV1("Gaurav Chaurasiya"));
    }

    @GetMapping(value = "/person", params = "version=2")
    public ResponseEntity<PersonV2> getSecondVersionOfPersonUsingRequestParam() {
        return ResponseEntity.ok(new PersonV2(new PersonV2.Name("Gaurav", "Chaurasiya")));
    }

    @GetMapping(value = "/person", headers = "x-api-version=1")
    public ResponseEntity<PersonV1> getFirstVersionOfPersonUsingRequestHeader() {
        return ResponseEntity.ok(new PersonV1("Gaurav Chaurasiya"));
    }

    @GetMapping(value = "/person", headers = "x-api-version=2")
    public ResponseEntity<PersonV2> getSecondVersionOfPersonUsingRequestHeader() {
        return ResponseEntity.ok(new PersonV2(new PersonV2.Name("Gaurav", "Chaurasiya")));
    }

    @GetMapping(value = "/person/accept", produces = "application/vnd.api-v1+json")
    public ResponseEntity<PersonV1> getFirstVersionOfPersonUsingAcceptHeader() {
        return ResponseEntity.ok(new PersonV1("Gaurav Chaurasiya"));
    }

    @GetMapping(value = "/person/accept", produces = "application/vnd.api-v2+json")
    public ResponseEntity<PersonV2> getSecondVersionOfPersonUsingAcceptHeader() {
        return ResponseEntity.ok(new PersonV2(new PersonV2.Name("Gaurav", "Chaurasiya")));
    }

}
