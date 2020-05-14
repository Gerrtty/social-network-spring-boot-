package ru.itis.socialnetworkboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.socialnetworkboot.model.User;
import ru.itis.socialnetworkboot.service.SubscribersServiceImpl;

import java.util.Optional;

@Controller
public class SubscribeController {

    private final SubscribersServiceImpl subscribersService;

    @Autowired
    public SubscribeController(SubscribersServiceImpl subscribersService) {
        this.subscribersService = subscribersService;
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/subscribe")
    public String subscribe(@RequestParam Long userId, Authentication authentication) {

        Optional<User> optionalUser = (Optional<User>) authentication.getPrincipal();

        subscribersService.subscribe(optionalUser.get(), new User(userId));
        return "redirect:/profile?id=" + userId;
    }

}
