package ru.itis.rest.rest;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.itis.rest.dto.SignInDto;
import ru.itis.rest.dto.TokenDto;
import ru.itis.rest.service.SignInServiceImpl;


@Controller
public class RegistrationController {

    private final SignInServiceImpl authService;

    @Autowired
    public RegistrationController(SignInServiceImpl authService) {
        this.authService = authService;
    }

    @SneakyThrows
    @PostMapping("/api/signIn")
    public ResponseEntity<TokenDto> signIn(@RequestBody SignInDto signInDto) throws AccessDeniedException {
        return ResponseEntity.ok(authService.signIn(signInDto));
    }


}
