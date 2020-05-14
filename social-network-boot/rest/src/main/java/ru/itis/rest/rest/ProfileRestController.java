package ru.itis.rest.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.rest.dto.ProfileInfoDto;
import ru.itis.rest.model.User;
import ru.itis.rest.service.PostServiceImpl;
import ru.itis.rest.service.ProfileServiceImpl;

@RestController
public class ProfileRestController {

    private final ProfileServiceImpl profileService;
    private final PostServiceImpl postService;

    public ProfileRestController(ProfileServiceImpl profileService,
                                 PostServiceImpl postService) {

        this.profileService = profileService;
        this.postService = postService;

    }

    @GetMapping(value = "/api/profile/{userId}")
    public ResponseEntity<?> getProfile(@PathVariable Long userId) {

        ProfileInfoDto profileInfoDto = profileService.getProfileInfo(new User(userId));
        profileInfoDto.setPosts(postService.getPosts(userId));

        return ResponseEntity.ok("200");
    }

}
