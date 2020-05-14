package ru.itis.socialnetworkboot.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.socialnetworkboot.model.User;
import ru.itis.socialnetworkboot.security.Role;
import ru.itis.socialnetworkboot.service.ConfirmServiceImpl;

import java.util.Optional;

@Controller
public class ConfirmController {

    private final ConfirmServiceImpl confirmService;

    public ConfirmController(ConfirmServiceImpl confirmService) {
        this.confirmService = confirmService;
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/confirm")
    public String confirm(Authentication authentication, @RequestParam Long id) {

        Optional<User> optionalUser = (Optional<User>) authentication.getPrincipal();

        confirmService.confirmRegistration(id);

        optionalUser.get().setRole(Role.CONFIRMED);

        return "confirm";
    }

}
