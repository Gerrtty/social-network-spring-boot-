package ru.itis.rest.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import ru.itis.rest.dto.PhotoDto;
import ru.itis.rest.model.User;
import ru.itis.rest.sequrity.jwt.details.UserDetailsImpl;
import ru.itis.rest.service.AlbumsServiceImpl;
import ru.itis.rest.service.CommentForPhotoServiceImpl;
import ru.itis.rest.service.PhotoService;

import java.util.List;
import java.util.Optional;

@RestController
public class AlbumsRestController {

    private final AlbumsServiceImpl albumsService;
    private final PhotoService photoService;
    private final CommentForPhotoServiceImpl commentForPhotoService;

    @Autowired
    public AlbumsRestController(AlbumsServiceImpl albumsService,
                                PhotoService photoService,
                                CommentForPhotoServiceImpl commentForPhotoService) {
        this.albumsService = albumsService;
        this.photoService = photoService;
        this.commentForPhotoService = commentForPhotoService;
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/api/users/{userId}/albums")
    public ResponseEntity<?> getAllAlbums(@PathVariable Long userId) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getDetails();

        return ResponseEntity.ok(albumsService.getAllByUser(new User(userDetails.getUserId()), userId));
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping(value = "/api/newAlbum")
    public ResponseEntity<?> newAlbum(@RequestBody String title) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getDetails();

        albumsService.createAlbum(new User(userDetails.getUserId()), title);

        return ResponseEntity.ok("200");
    }

    @GetMapping("/api/album/{albumId}/photos")
    public ResponseEntity<?> getPhotosInAlbum(@PathVariable("albumId") Long albumId) {
        List<PhotoDto> photoDtos =  photoService.getAlbumsPhotos(albumId);
        return ResponseEntity.ok(photoDtos);
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/api/photo/{photoId}/comment")
    public ResponseEntity<?> leaveCommentToPhoto(@PathVariable("photoId") Long photoId,
                                      @RequestBody String text) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getDetails();

        commentForPhotoService.leaveComment(new User(userDetails.getUserId()), photoId, text);

        return ResponseEntity.ok("200");
    }


    @GetMapping("/api/photo/{photoId}")
    public ResponseEntity<?> getComments(@PathVariable("photoId") Long photoId) {
        return ResponseEntity.ok(commentForPhotoService.getComments(photoId));
    }

}

