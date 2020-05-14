package ru.itis.rest.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.rest.dto.UsersDto;
import ru.itis.rest.service.UsersServiceImpl;

@RestController
public class UsersRestController {

    private final UsersServiceImpl usersService;

    @Autowired
    public UsersRestController(UsersServiceImpl usersService) {
        this.usersService = usersService;
    }

    @RequestMapping(value = "/api/users", method = RequestMethod.GET)
    public ResponseEntity<?> showAllUsers() {
        return ResponseEntity.ok(UsersDto.from(usersService.allUsers()));
    }

}
