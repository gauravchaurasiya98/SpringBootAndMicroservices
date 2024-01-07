package in.gaurav.service.impl;

import in.gaurav.entity.ContactNumber;
import in.gaurav.entity.Person;
import in.gaurav.repository.ContactNumberRepository;
import in.gaurav.repository.PersonRepository;
import in.gaurav.service.PersonManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
public class PersonManagementServiceImpl implements PersonManagementService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ContactNumberRepository contactNumbersRepository;

    @Override
    public Person savePersonDetails(Person person) {
        person.getContactNumberSet().forEach(contactNumber -> contactNumber.setPerson(person));
        return personRepository.saveAndFlush(person);
    }

    @Override
    public ContactNumber saveContactNumberDetails(ContactNumber contactNumber) {
        Person savedPerson = personRepository.saveAndFlush(contactNumber.getPerson());
        contactNumber.setPerson(savedPerson);
        return contactNumbersRepository.save(contactNumber);
    }

    @Override
    public List<ContactNumber> saveAllContactNumberDetails(Set<ContactNumber> contactNumbers) {
        if (!CollectionUtils.isEmpty(contactNumbers)) {
            ContactNumber contactNumber = contactNumbers.stream().findFirst().get();
            Person savedPerson = personRepository.saveAndFlush(contactNumber.getPerson());
            contactNumbers.forEach(contactNumberToSave -> contactNumberToSave.setPerson(savedPerson));
            return contactNumbersRepository.saveAll(contactNumbers);
        }
        return Collections.emptyList();
    }

}
