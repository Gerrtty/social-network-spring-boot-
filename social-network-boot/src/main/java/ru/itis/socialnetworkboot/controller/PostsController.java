package ru.itis.socialnetworkboot.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.itis.socialnetworkboot.dto.PostDto;
import ru.itis.socialnetworkboot.model.User;
import ru.itis.socialnetworkboot.service.PostServiceImpl;

import java.util.Optional;

@Controller
public class PostsController {

    private final PostServiceImpl postService;

    public PostsController(PostServiceImpl postService) {
        this.postService = postService;
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/addPost", method = RequestMethod.POST)
    public String addPost(Authentication authentication, @ModelAttribute("post") PostDto postDto) {

        Optional<User> optionalUser = (Optional<User>) authentication.getPrincipal();

        postService.addPost(postDto, optionalUser.get());

        return "redirect:/profile?id=" + postDto.getPageId();

    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/page/{pageId}/post/{postId}/delete")
    public String deletePost(Authentication authentication,
                             @PathVariable Long postId,
                             @PathVariable Long pageId) {

        Optional<User> optionalUser = (Optional<User>) authentication.getPrincipal();

        postService.delete(postId, optionalUser.get().getUserId());

        return "redirect:/profile?id=" + pageId;

    }

}
