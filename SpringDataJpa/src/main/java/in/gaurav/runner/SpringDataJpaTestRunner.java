package in.gaurav.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.gaurav.entity.Student;
import in.gaurav.repo.StudentRepo;

@Component
public class SpringDataJpaTestRunner implements CommandLineRunner {

	@Autowired
	private StudentRepo studentRepo;

	@Override
	public void run(String... args) throws Exception {
		List<Student> students = List.of(
				new Student("Gaurav Chaurasiya", (byte) 24, 'M',
						"Maya Palace, Ward No - 10, Bichli Tola, Maheshkhunt, Khagaria, Bihar - 851213"),
				new Student("Rahul Jacker", (byte) 28, 'M', "Mumbai"),
				new Student("Ammy Jackson", (byte) 22, 'F', "Chandigarh"));
		studentRepo.saveAllAndFlush(students);
		studentRepo.findAll().forEach(System.out::println);
	}

}
