package ru.itis.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.rest.model.User;
import ru.itis.rest.repository.UsersRepository;

import java.util.List;

@Service
public class UsersServiceImpl {

    private final UsersRepository usersRepository;

    @Autowired
    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<User> allUsers() {
        return usersRepository.findAll();
    }

}
