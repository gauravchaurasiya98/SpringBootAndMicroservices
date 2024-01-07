package in.gaurav.user.service.impl;

import in.gaurav.user.entity.Post;
import in.gaurav.user.entity.User;
import in.gaurav.user.exception.PostNotFoundException;
import in.gaurav.user.exception.UserNotFoundException;
import in.gaurav.user.repository.PostRepository;
import in.gaurav.user.repository.UserRepository;
import in.gaurav.user.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Transactional(rollbackOn = Exception.class)
public class UserServiceImpl implements UserService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    /*private static final AtomicInteger idGenerator = new AtomicInteger(101);
    private static final Set<User> users = new LinkedHashSet<>();

    static {
        users.add(new User(idGenerator.getAndIncrement(), "Jack", LocalDate.now().minusYears(25L)));
        users.add(new User(idGenerator.getAndIncrement(), "Thomas", LocalDate.now().minusYears(30L)));
        users.add(new User(idGenerator.getAndIncrement(), "Robin", LocalDate.now().minusYears(35L)));
    }*/

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Integer userId) {
        /*return users.stream()
                .filter(user -> user.getId().equals(userId))
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException(
                        "User is not present with id : ".concat(userId.toString())));*/
        return userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(
                        "User is not present with id : ".concat(userId.toString())));
    }

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUserById(Integer userId) {
        isUserExist(userId);
        userRepository.deleteById(userId);
    }

    @Override
    public User updateUser(Integer userId, User user) {
        User userToUpdate = getUserById(userId);
        //BeanUtils.copyProperties(user, userToUpdate, "id", "posts");
        userToUpdate.setName(user.getName());
        userToUpdate.setBirthDate(user.getBirthDate());
        return userRepository.save(userToUpdate);
    }

    @Override
    public void updateUserDob(Integer userId, User user) {
        isUserExist(userId);
        userRepository.updateBirthDateById(userId, user.getBirthDate());
    }

    @Override
    public List<Post> getAllPostsForAnUser(Integer userId) {
        User user = getUserById(userId);
        return user.getPosts();
    }

    @Override
    public Post getPostForAnUser(Integer userId, Integer postId) {
        isUserExist(userId);
        return postRepository.findById(postId)
                .orElseThrow(() -> new PostNotFoundException(
                        "No post has found for post id : ".concat(postId.toString())));
    }

    @Override
    public void createPostForAnUser(Integer userId, Post post) {
        User user = getUserById(userId);
        post.setUser(user);
        postRepository.save(post);
    }

    @Override
    public Post updatePostForAnUser(Integer userId, Integer postId, Post post) {
        Post postToUpdate = getPostForAnUser(userId, postId);
        postToUpdate.setDescription(post.getDescription());
        return postRepository.save(postToUpdate);
    }

    @Override
    public void deletePostForAnUser(Integer userId, Integer postId) {
        isUserExist(userId);
        if (!postRepository.existsById(postId)) {
            throw new PostNotFoundException("No post has found for post id : ".concat(postId.toString()));
        }
        postRepository.deleteById(postId);
    }

    @Override
    public void deleteAllPostsForAnUser(Integer userId) {
        isUserExist(userId);
        postRepository.deleteAllPostsForAnUser(userId);
    }

    private void isUserExist(Integer userId) {
        if (!userRepository.existsById(userId)) {
            throw new UserNotFoundException("User is not present with id : ".concat(userId.toString()));
        }
    }

}
