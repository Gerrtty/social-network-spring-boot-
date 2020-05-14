package ru.itis.socialnetworkboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.socialnetworkboot.model.User;
import ru.itis.socialnetworkboot.service.LikesServiceImpl;

import java.util.Optional;

@Controller
public class LikesController {

    private final LikesServiceImpl likesService;

    @Autowired
    public LikesController(LikesServiceImpl likesService) {
        this.likesService = likesService;
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/like")
    public String like(Authentication authentication, @RequestParam Long postId, @RequestParam String page) {

        Optional<User> optionalUser = (Optional<User>) authentication.getPrincipal();
        User user = optionalUser.get();

        likesService.saveLike(postId, user);

        return "redirect:/" + page;

    }

}
