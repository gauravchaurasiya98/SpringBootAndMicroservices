package in.gaurav.service;

import in.gaurav.entity.ContactNumber;
import in.gaurav.entity.Person;

import java.util.List;
import java.util.Set;

public interface PersonManagementService {
    Person savePersonDetails(Person person);
    ContactNumber saveContactNumberDetails(ContactNumber contactNumber);
    List<ContactNumber> saveAllContactNumberDetails(Set<ContactNumber> contactNumbers);
}
