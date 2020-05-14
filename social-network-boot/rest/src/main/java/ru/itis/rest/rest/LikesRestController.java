package ru.itis.rest.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.rest.model.User;
import ru.itis.rest.sequrity.jwt.details.UserDetailsImpl;
import ru.itis.rest.service.LikesServiceImpl;

@RestController
public class LikesRestController {

    private final LikesServiceImpl likesService;

    @Autowired
    public LikesRestController(LikesServiceImpl likesService) {
        this.likesService = likesService;
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/api/{postId}/like")
    public void like(@PathVariable Long postId) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getDetails();

        likesService.saveLike(postId, new User(userDetails.getUserId()));

    }

}
