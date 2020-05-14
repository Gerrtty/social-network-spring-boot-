package ru.itis.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.rest.model.User;
import ru.itis.rest.repository.UsersRepository;

import javax.transaction.Transactional;

@Service
public class AvaServiceImpl {

    private final UsersRepository usersRepository;

    @Autowired
    public AvaServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Transactional
    public void setAva(String path, Long userId, User user) {
        usersRepository.updatePathToAvaByUserId(path, userId);
        user.setPathToAva(path);
    }
}
