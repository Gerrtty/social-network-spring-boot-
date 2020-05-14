package ru.itis.socialnetworkboot.controller;

import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.socialnetworkboot.model.User;
import ru.itis.socialnetworkboot.repository.interfaces.UsersRepository;
import ru.itis.socialnetworkboot.service.PostServiceImpl;
import ru.itis.socialnetworkboot.service.ProfileServiceImpl;
import ru.itis.socialnetworkboot.util.Logger;

import javax.transaction.Transactional;
import java.util.Optional;

@Controller
public class ProfileController {

    private final ProfileServiceImpl profileService;
    private final PostServiceImpl postService;
    private final UsersRepository usersRepository;

    private Long page;

    public ProfileController(ProfileServiceImpl profileService, PostServiceImpl postService, UsersRepository usersRepository) {
        this.profileService = profileService;
        this.postService = postService;
        this.usersRepository = usersRepository;
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/profile")
    public String show(Model model, Authentication authentication, @RequestParam(defaultValue = "0") Long id) {

        Optional<User> optionalUser = (Optional<User>) authentication.getPrincipal();

        Long authUserId = optionalUser.get().getUserId();

        User user;

        if(id == 0) {
            user = optionalUser.get();
            id = user.getUserId();
        }

        else {
            optionalUser = usersRepository.findById(id);

            if(!optionalUser.isPresent()) {
                return "error";
            }

            else {
                user = optionalUser.get();
                id = user.getUserId();
            }

        }

        model.addAttribute("user", profileService.getProfileInfo(user));
        model.addAttribute("authUserId", authUserId);
        model.addAttribute("posts", postService.getPosts(id));
        model.addAttribute("id", id);

        return "profile";
    }

}
