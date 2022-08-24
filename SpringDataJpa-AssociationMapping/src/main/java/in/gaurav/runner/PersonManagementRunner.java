package in.gaurav.runner;

import in.gaurav.entity.ContactNumber;
import in.gaurav.entity.Person;
import in.gaurav.service.PersonManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class PersonManagementRunner implements CommandLineRunner {

    @Autowired
    private PersonManagementService personManagementService;

    @Override
    public void run(String... args) {
        Person person = new Person();
        person.setPersonName("Gaurav");
        person.setPersonAddress("Maheshkhunt");
        ContactNumber contactNumber1 = new ContactNumber();
        contactNumber1.setNumber(9988776655L);
        contactNumber1.setNumberType("Personal");
        contactNumber1.setOperator("Jio");
        contactNumber1.setPerson(person);
        ContactNumber contactNumber2 = new ContactNumber();
        contactNumber2.setNumber(5566778899L);
        contactNumber2.setNumberType("Home");
        contactNumber2.setOperator("Jio");
        contactNumber2.setPerson(person);
        person.setContactNumberSet(Set.of(contactNumber1, contactNumber2));
        personManagementService.savePersonDetails(person);
    }
}
