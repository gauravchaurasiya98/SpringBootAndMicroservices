package in.gaurav.service.impl;

import in.gaurav.entity.ContactNumber;
import in.gaurav.entity.Person;
import in.gaurav.repository.ContactNumberRepository;
import in.gaurav.repository.PersonRepository;
import in.gaurav.service.PersonManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class PersonManagementManagementServiceImpl implements PersonManagementService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ContactNumberRepository contactNumbersRepository;

    @Override
    public Person savePersonDetails(Person person) {
        return personRepository.saveAndFlush(person);
    }

    @Override
    public ContactNumber saveContactNumberDetails(ContactNumber contactNumber) {
        return contactNumbersRepository.saveAndFlush(contactNumber);
    }

    @Override
    public List<ContactNumber> saveAllContactNumberDetails(Set<ContactNumber> contactNumbers) {
        return contactNumbersRepository.saveAllAndFlush(contactNumbers);
    }

}
