package ru.itis.socialnetworkboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.socialnetworkboot.dto.CommentDto;
import ru.itis.socialnetworkboot.model.User;
import ru.itis.socialnetworkboot.security.Role;
import ru.itis.socialnetworkboot.service.CommentsServiceImpl;

import java.util.List;
import java.util.Optional;

@Controller
public class CommentsController {

    private final CommentsServiceImpl commentsService;

    @Autowired
    public CommentsController(CommentsServiceImpl commentsService) {
        this.commentsService = commentsService;
    }

    @PreAuthorize("hasRole('CONFIRMED')")
//    @PreAuthorize("isAuthenticated()")
    @PostMapping("/comment")
    public String writeComment(@ModelAttribute("comment") CommentDto commentDto,
                               Model model,
                               Authentication authentication) {

        Optional<User> optionalUser = (Optional<User>) authentication.getPrincipal();

        if(optionalUser.get().getRole() == Role.CONFIRMED) {
            commentsService.addComment(commentDto, optionalUser.get());
            return "redirect:/";
        }

        else {
            model.addAttribute("message", "Confirm you'r registration");
            return "err";
        }

    }

    @GetMapping("/post/{postId}/comments/{page}")
    public String getComments(Model model, @PathVariable Long postId, @PathVariable Integer page) {

        List<CommentDto> comments = commentsService.getComments(postId, page);

        model.addAttribute("comments", comments);

        return "comments";

    }

}
