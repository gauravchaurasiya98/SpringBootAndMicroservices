package in.gaurav.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.gaurav.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

}
