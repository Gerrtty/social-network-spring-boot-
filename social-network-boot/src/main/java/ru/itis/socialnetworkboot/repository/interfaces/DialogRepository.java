package ru.itis.socialnetworkboot.repository.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.socialnetworkboot.model.Dialog;
import ru.itis.socialnetworkboot.model.User;

import java.util.Optional;

public interface DialogRepository extends JpaRepository<Dialog, Long> {

    Optional<Dialog> findByUser1AndUser2(User user1, User user2);
}
