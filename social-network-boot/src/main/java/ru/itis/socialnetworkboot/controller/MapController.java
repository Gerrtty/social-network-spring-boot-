package ru.itis.socialnetworkboot.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.socialnetworkboot.dto.MapDto;
import ru.itis.socialnetworkboot.service.LocationService;

@Controller
public class MapController {

    private final LocationService locationService;

    public MapController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/photo/{photoId}/map")
    public String map(@PathVariable Long photoId, Model model) {
        model.addAttribute("mapDto", locationService.getLocation(photoId));
        model.addAttribute("photoId", photoId);
        return "map";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/photo/{photoId}/map")
    public String loc(@ModelAttribute MapDto mapDto, @PathVariable Long photoId) {
        locationService.setLocation(mapDto, photoId);
        return "redirect:/photo/" + photoId + "/map";
    }

}
