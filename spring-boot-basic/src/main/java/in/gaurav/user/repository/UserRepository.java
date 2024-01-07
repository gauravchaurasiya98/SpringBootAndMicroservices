package in.gaurav.user.repository;

import in.gaurav.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Modifying
    @Query("UPDATE in.gaurav.user.entity.User u SET u.birthDate = :newBirthDate WHERE u.id = :userId")
    void updateBirthDateById(Integer userId, LocalDate newBirthDate);
}
