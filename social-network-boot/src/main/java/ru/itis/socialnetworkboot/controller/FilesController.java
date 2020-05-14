package ru.itis.socialnetworkboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.socialnetworkboot.dto.UploadForm;
import ru.itis.socialnetworkboot.model.User;
import ru.itis.socialnetworkboot.service.AvaServiceImpl;
import ru.itis.socialnetworkboot.service.FilesUploadServiceImpl;
import ru.itis.socialnetworkboot.service.PhotoService;
import ru.itis.socialnetworkboot.util.Logger;

import javax.servlet.annotation.MultipartConfig;
import java.util.Optional;

@Controller
@MultipartConfig
public class FilesController {

    private final FilesUploadServiceImpl filesUploadService;
    private final AvaServiceImpl avaService;
    private final PhotoService photoService;

    @Autowired
    public FilesController(FilesUploadServiceImpl filesUploadService, AvaServiceImpl avaService, PhotoService photoService) {
        this.filesUploadService = filesUploadService;
        this.avaService = avaService;
        this.photoService = photoService;
    }

    @PostMapping("/upload")
    @PreAuthorize("isAuthenticated()")
    public String multiFileUpload(@ModelAttribute UploadForm form, Authentication authentication) {

        Optional<User> optionalUser = (Optional<User>) authentication.getPrincipal();

        avaService.setAva(upload(form, optionalUser.get()), form.getUserId(), optionalUser.get());

        return "redirect:/profile";

    }

    private String upload(UploadForm form, User user) {
        form.setUserId(user.getUserId());
        return filesUploadService.upload(form);
    }

    @PostMapping("/addPhoto")
    @PreAuthorize("isAuthenticated()")
    public String addPhoto(@ModelAttribute UploadForm form, Authentication authentication) {

        Optional<User> optionalUser = (Optional<User>) authentication.getPrincipal();

        photoService.setPhoto(form, upload(form, optionalUser.get()));

        return "redirect:/profile";

    }

}


