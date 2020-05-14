package ru.itis.socialnetworkboot.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.socialnetworkboot.model.User;
import ru.itis.socialnetworkboot.service.SubscribersServiceImpl;

import java.util.Optional;

@Controller
public class NewsController {

    private final SubscribersServiceImpl subscribersService;

    public NewsController(SubscribersServiceImpl subscribersService) {
        this.subscribersService = subscribersService;
    }

    @GetMapping("/news")
    public String getNews(Authentication authentication, Model model) {

        Optional<User> optionalUser = (Optional<User>) authentication.getPrincipal();

        model.addAttribute("posts", subscribersService.getPosts(optionalUser.get().getUserId()));
        model.addAttribute("id", optionalUser.get().getUserId());

        return "fied";
    }

}
