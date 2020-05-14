package ru.itis.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.rest.model.Comment;
import ru.itis.rest.model.Post;

import java.util.List;

public interface CommentsRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAllByPost(Post post);

}
