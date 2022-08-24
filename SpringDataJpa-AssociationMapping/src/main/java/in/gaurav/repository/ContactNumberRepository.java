package in.gaurav.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.gaurav.entity.ContactNumber;

public interface ContactNumberRepository extends JpaRepository<ContactNumber, Long> {

}
