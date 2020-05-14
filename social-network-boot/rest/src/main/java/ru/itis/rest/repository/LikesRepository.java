package ru.itis.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.rest.model.Like;
import ru.itis.rest.model.Post;
import ru.itis.rest.model.User;

public interface LikesRepository extends JpaRepository<Like, Long> {

    Long countAllByPost(Post post);

    Like findByAuthorAndPost(User author, Post post);

}
