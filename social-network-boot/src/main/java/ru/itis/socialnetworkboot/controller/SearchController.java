package ru.itis.socialnetworkboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import ru.itis.socialnetworkboot.dto.AjaxResponseBody;
import ru.itis.socialnetworkboot.dto.SearchCriteria;
import ru.itis.socialnetworkboot.dto.UsersDto;
import ru.itis.socialnetworkboot.service.UsersServiceImpl;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SearchController {

    private final UsersServiceImpl userService;

    public SearchController(UsersServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("/api/search")
    @ResponseBody
    public ResponseEntity<?> getSearchResultViaAjax(
            @Valid @RequestBody SearchCriteria search, Errors errors) {

        AjaxResponseBody result = new AjaxResponseBody();

        if (errors.hasErrors()) {

            result.setMsg(errors.getAllErrors()
                    .stream().map(x -> x.getDefaultMessage())
                    .collect(Collectors.joining(",")));

            return ResponseEntity.badRequest().body(result);

        }

        List<UsersDto> users = UsersDto.from(userService.getAllByFirstNameAndSecondName(search.getUsername()));
        if (users.isEmpty()) {
            result.setMsg("no user found!");
        } else {
            result.setMsg("success");
        }
        result.setResult(users);

        return ResponseEntity.ok(result);

    }
}
