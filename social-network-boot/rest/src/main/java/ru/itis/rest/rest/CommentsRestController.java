package ru.itis.rest.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import ru.itis.rest.dto.CommentDto;
import ru.itis.rest.model.User;
import ru.itis.rest.sequrity.jwt.details.UserDetailsImpl;
import ru.itis.rest.service.CommentsServiceImpl;
import java.util.List;

@RestController
public class CommentsRestController {

    private final CommentsServiceImpl commentService;

    public CommentsRestController(CommentsServiceImpl commentService) {
        this.commentService = commentService;
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/api/post/{postId}/createComment")
    public ResponseEntity<?> create(@PathVariable Long postId, @RequestBody CommentDto commentDto) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getDetails();

        commentDto.setPostId(postId);

        commentService.addComment(commentDto, new User(userDetails.getUserId()));

        return ResponseEntity.ok("200");
    }

    @GetMapping("/api/comments/{postId}/{page}")
    public ResponseEntity<List<CommentDto>> getComments(@PathVariable Long postId, @PathVariable Integer page) {

        List<CommentDto> comments = commentService.getComments(postId, page);

        return ResponseEntity.ok(comments);

    }

}
