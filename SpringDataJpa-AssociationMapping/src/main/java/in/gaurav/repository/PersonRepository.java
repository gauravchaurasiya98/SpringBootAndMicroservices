package in.gaurav.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.gaurav.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}
