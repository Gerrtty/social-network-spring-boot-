package ru.itis.rest.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.rest.model.User;
import ru.itis.rest.sequrity.jwt.details.UserDetailsImpl;
import ru.itis.rest.service.SubscribersServiceImpl;


@RestController
public class SubscribeRestController {

    private final SubscribersServiceImpl subscribersService;

    @Autowired
    public SubscribeRestController(SubscribersServiceImpl subscribersService) {
        this.subscribersService = subscribersService;
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/api/user/subscribe/{userId}")
    public ResponseEntity<?> subscribe(@PathVariable Long userId) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getDetails();

        subscribersService.subscribe(new User(userDetails.getUserId()), new User(userId));
        return ResponseEntity.ok("200");
    }

}
