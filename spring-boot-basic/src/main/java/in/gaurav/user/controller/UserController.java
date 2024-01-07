package in.gaurav.user.controller;

import in.gaurav.user.entity.Post;
import in.gaurav.user.entity.User;
import in.gaurav.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> retrieveUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<EntityModel<User>> retrieveUserById(@PathVariable Integer userId) {
        User user = userService.getUserById(userId);
        Link link = linkTo(methodOn(getClass()).retrieveUsers()).withRel("all-users");
        /*EntityModel<User> entityModel = EntityModel.of(user);
        entityModel.add(link);*/
        return ResponseEntity.ok(EntityModel.of(user, link));
    }

    @PostMapping("/users")
    public ResponseEntity<Void> registerUser(@Valid @RequestBody User user) {
        userService.createUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{userId}")
                .buildAndExpand(user.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/users/{userId}")
    public ResponseEntity<User> updateUser(
            @PathVariable Integer userId, @Valid @RequestBody User user) {
        User updatedUser = userService.updateUser(userId, user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
        return ResponseEntity.accepted().location(location).body(updatedUser);
    }

    @PatchMapping("/users/{userId}")
    public ResponseEntity<Void> updateUserDob(
            @PathVariable Integer userId, @RequestBody User user) {
        userService.updateUserDob(userId, user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
        return ResponseEntity.accepted().location(location).build();
    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer userId) {
        userService.deleteUserById(userId);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/users/{userId}/posts")
    public ResponseEntity<List<Post>> retrieveAllPostsForAnUser(@PathVariable Integer userId) {
        return ResponseEntity.ok(userService.getAllPostsForAnUser(userId));
    }

    @GetMapping("/users/{userId}/posts/{postId}")
    public ResponseEntity<EntityModel<Post>> retrievePostForAnUser(
            @PathVariable Integer userId, @PathVariable Integer postId) {
        Post post = userService.getPostForAnUser(userId, postId);
        Link link = linkTo(methodOn(getClass()).retrieveAllPostsForAnUser(userId)).withRel("all-posts");
        /*EntityModel<User> entityModel = EntityModel.of(post);
        entityModel.add(link);*/
        return ResponseEntity.ok(EntityModel.of(post, link));
    }

    @PostMapping("/users/{userId}/posts")
    public ResponseEntity<Void> createPostForAnUser(
            @PathVariable Integer userId, @Valid @RequestBody Post post) {
        userService.createPostForAnUser(userId, post);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{postId}")
                .buildAndExpand(post.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/users/{userId}/posts/{postId}")
    public ResponseEntity<Post> updatePostForAnUser(
            @PathVariable Integer userId, @PathVariable Integer postId, @Valid @RequestBody Post post) {
        Post updatedPost = userService.updatePostForAnUser(userId, postId, post);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
        return ResponseEntity.accepted().location(location).body(updatedPost);
    }

    @DeleteMapping("/users/{userId}/posts/{postId}")
    public ResponseEntity<Void> deletePostForAnUser(
            @PathVariable Integer userId, @PathVariable Integer postId) {
        userService.deletePostForAnUser(userId, postId);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/users/{userId}/posts")
    public ResponseEntity<Void> deleteAllPostsForAnUser(@PathVariable Integer userId) {
        userService.deleteAllPostsForAnUser(userId);
        return ResponseEntity.accepted().build();
    }

}
