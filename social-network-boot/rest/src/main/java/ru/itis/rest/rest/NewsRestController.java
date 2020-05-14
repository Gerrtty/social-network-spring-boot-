package ru.itis.rest.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.rest.dto.PostDto;
import ru.itis.rest.sequrity.jwt.details.UserDetailsImpl;
import ru.itis.rest.service.SubscribersServiceImpl;
import java.util.List;

@RestController
public class NewsRestController {

    private final SubscribersServiceImpl subscribersService;

    @Autowired
    public NewsRestController(SubscribersServiceImpl subscribersService) {
        this.subscribersService = subscribersService;
    }

    @GetMapping("/api/news")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<PostDto>> getNews() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getDetails();

        return ResponseEntity.ok(subscribersService.getPosts(userDetails.getUserId()));
    }

}
