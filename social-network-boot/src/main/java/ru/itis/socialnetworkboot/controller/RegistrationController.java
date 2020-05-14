package ru.itis.socialnetworkboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.itis.socialnetworkboot.dto.RegistrationDto;
import ru.itis.socialnetworkboot.model.User;
import ru.itis.socialnetworkboot.service.AuthServiceImpl;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    private final AuthServiceImpl authService;

    @Autowired
    public RegistrationController(AuthServiceImpl authService) {
        this.authService = authService;
    }

    @RequestMapping(value = "/reg", method = RequestMethod.GET)
    public String showReg(Model model) {
        model.addAttribute("registrationDto", new RegistrationDto());
        return "reg";
    }

    @PostMapping(value = "/reg")
    public String register(@ModelAttribute @Valid RegistrationDto registrationDto,
                           BindingResult bindingResult) {

        User user;
        if (bindingResult.hasErrors()) {
            return "reg";
        }

        else {
            user = authService.register(registrationDto);
        }

        if(user != null) {
            return "redirect:/profile?id=" + user.getUserId();
        }

        return "redirect:/reg";

    }


}
