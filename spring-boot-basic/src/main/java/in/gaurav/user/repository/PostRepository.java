package in.gaurav.user.repository;

import in.gaurav.user.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface PostRepository extends JpaRepository<Post, Integer> {
    @Modifying
    @Query("delete from Post p where p.user.id = :userId")
    void deleteAllPostsForAnUser(Integer userId);
}
