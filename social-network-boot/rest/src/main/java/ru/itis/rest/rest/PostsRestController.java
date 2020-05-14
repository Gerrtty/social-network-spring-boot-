package ru.itis.rest.rest;

import com.sun.net.httpserver.Authenticator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import ru.itis.rest.dto.PostDto;
import ru.itis.rest.model.User;
import ru.itis.rest.sequrity.jwt.details.UserDetailsImpl;
import ru.itis.rest.service.PostServiceImpl;

@RestController
public class PostsRestController {

    private final PostServiceImpl postService;

    @Autowired
    public PostsRestController(PostServiceImpl postService) {
        this.postService = postService;
    }

    @PreAuthorize("isAuthenticated()")
    @DeleteMapping("/api/post/{postId}/delete")
    public ResponseEntity deletePost(@PathVariable Long postId) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        try {
            postService.delete(postId, userDetails.getUserId());

            return new ResponseEntity<Authenticator.Success>(HttpStatus.OK);

        } catch (AccessDeniedException e) {

            return new ResponseEntity<Error>(HttpStatus.FORBIDDEN);
        }
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/api/addPost")
    public ResponseEntity<?> addPost(@RequestBody PostDto postDto) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        PostDto post = postService.addPost(postDto, new User(userDetails.getUserId()));

        return ResponseEntity.ok(post);

    }

}
