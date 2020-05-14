package ru.itis.rest.service;

import org.springframework.stereotype.Service;
import ru.itis.rest.repository.UsersRepository;

import javax.transaction.Transactional;

@Service
public class ConfirmServiceImpl {

    private final UsersRepository usersRepository;

    public ConfirmServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Transactional
    public void confirmRegistration(Long userId) {
        usersRepository.setConfirmFlag(userId);
    }
}
