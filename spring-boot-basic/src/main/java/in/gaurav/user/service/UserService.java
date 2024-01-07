package in.gaurav.user.service;

import in.gaurav.user.entity.Post;
import in.gaurav.user.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(Integer userId);

    void createUser(User user);

    void deleteUserById(Integer userId);

    User updateUser(Integer userId, User user);

    void updateUserDob(Integer userId, User user);

    List<Post> getAllPostsForAnUser(Integer userId);

    Post getPostForAnUser(Integer userId, Integer postId);

    void createPostForAnUser(Integer userId, Post post);

    Post updatePostForAnUser(Integer userId, Integer postId, Post post);

    void deletePostForAnUser(Integer userId, Integer postId);

    void deleteAllPostsForAnUser(Integer userId);
}
