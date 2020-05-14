package ru.itis.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.rest.model.Dialog;
import ru.itis.rest.model.Message;

import java.util.List;

public interface MessagesRepository extends JpaRepository<Message, Long> {

    List<Message> findAllByDialogOrderByDateDesc(Dialog dialog);

}
