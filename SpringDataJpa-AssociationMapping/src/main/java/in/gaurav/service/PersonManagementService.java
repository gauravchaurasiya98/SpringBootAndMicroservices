package in.gaurav.service;

import in.gaurav.entity.ContactNumber;
import in.gaurav.entity.Person;

import java.util.List;

public interface PersonManagementService {
    Person savePersonDetails(Person person);
    ContactNumber saveContactNumberDetails(ContactNumber contactNumber);
    List<ContactNumber> saveAllContactNumberDetails(List<ContactNumber> contactNumberList);
}
