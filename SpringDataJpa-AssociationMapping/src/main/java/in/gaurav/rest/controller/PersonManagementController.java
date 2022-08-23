package in.gaurav.rest.controller;

import in.gaurav.entity.ContactNumber;
import in.gaurav.entity.Person;
import in.gaurav.service.PersonManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/person/management/", produces = MediaType.APPLICATION_JSON_VALUE)
public class PersonManagementController {

    @Autowired
    private PersonManagementService personManagementService;

    @PostMapping(value = "savePersonDetails", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> savePersonDetails(@RequestBody Person person) {
        try {
            return ResponseEntity.ok(personManagementService.savePersonDetails(person));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e);
        }
    }

    @PostMapping(value = "saveContactNumberDetails", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveContactNumberDetails(@RequestBody ContactNumber contactNumber) {
        try {
            return ResponseEntity.ok(personManagementService.saveContactNumberDetails(contactNumber));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e);
        }
    }
}
