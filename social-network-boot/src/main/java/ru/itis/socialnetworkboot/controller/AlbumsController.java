package ru.itis.socialnetworkboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.socialnetworkboot.dto.CommentForPhotoDto;
import ru.itis.socialnetworkboot.dto.PhotoDto;
import ru.itis.socialnetworkboot.model.User;
import ru.itis.socialnetworkboot.service.AlbumsServiceImpl;
import ru.itis.socialnetworkboot.service.CommentForPhotoServiceImpl;
import ru.itis.socialnetworkboot.service.PhotoService;

import java.util.List;
import java.util.Optional;

@Controller
public class AlbumsController {

    private final AlbumsServiceImpl albumsService;
    private final PhotoService photoService;
    private final CommentForPhotoServiceImpl commentForPhotoService;

    @Autowired
    public AlbumsController(AlbumsServiceImpl albumsService, PhotoService photoService, CommentForPhotoServiceImpl commentForPhotoService) {
        this.albumsService = albumsService;
        this.photoService = photoService;
        this.commentForPhotoService = commentForPhotoService;
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/albums", method = RequestMethod.GET)
    public ModelAndView show(Authentication authentication, @RequestParam Long userId) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("album");

        Optional<User> optionalUser = (Optional<User>) authentication.getPrincipal();

        modelAndView.addObject("albums", albumsService.getAllByUser(optionalUser.get(), userId));

        return modelAndView;
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/newAlbum", method = RequestMethod.POST)
    public String newAlbum(Authentication authentication, @ModelAttribute("title") String title) {

        Optional<User> optionalUser = (Optional<User>) authentication.getPrincipal();
        albumsService.createAlbum(optionalUser.get(), title);

        return "album";
    }

    @GetMapping("/album/{albumId}/photos")
    public ModelAndView getPhotosInAlbum(@PathVariable("albumId") Long albumId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("photos");

        List<PhotoDto> photoDtos =  photoService.getAlbumsPhotos(albumId);

        modelAndView.addObject("photos", photoDtos);
        modelAndView.addObject("albumTitle", photoDtos.get(0).getAlbumTitle());

        return modelAndView;
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/photo/{photoId}/comment")
    public String leaveCommentToPhoto(Authentication authentication,
                                    @PathVariable("photoId") Long photoId,
                                    @ModelAttribute("text") String text) {

        Optional<User> optionalUser = (Optional<User>) authentication.getPrincipal();

        commentForPhotoService.leaveComment(optionalUser.get(), photoId, text);

        return "redirect:/";
    }


    @GetMapping("/photo/{photoId}")
    public ModelAndView getComments(@PathVariable("photoId") Long photoId) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("comments");
        modelAndView.addObject("comments", commentForPhotoService.getComments(photoId));

        return modelAndView;
    }

}
