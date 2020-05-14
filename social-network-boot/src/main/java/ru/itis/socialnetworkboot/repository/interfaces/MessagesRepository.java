package ru.itis.socialnetworkboot.repository.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.socialnetworkboot.model.Dialog;
import ru.itis.socialnetworkboot.model.Message;

import java.util.List;

public interface MessagesRepository extends JpaRepository<Message, Long> {

    List<Message> findAllByDialogOrderByDateDesc(Dialog dialog);

}
