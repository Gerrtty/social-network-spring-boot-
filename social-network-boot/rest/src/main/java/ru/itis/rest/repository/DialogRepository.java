package ru.itis.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.rest.model.Dialog;
import ru.itis.rest.model.User;


import java.util.Optional;

public interface DialogRepository extends JpaRepository<Dialog, Long> {

    Optional<Dialog> findByUser1AndUser2(User user1, User user2);
}
