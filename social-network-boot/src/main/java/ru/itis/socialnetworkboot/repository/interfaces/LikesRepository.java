package ru.itis.socialnetworkboot.repository.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.socialnetworkboot.model.Like;
import ru.itis.socialnetworkboot.model.Post;
import ru.itis.socialnetworkboot.model.User;

public interface LikesRepository extends JpaRepository<Like, Long> {

    Long countAllByPost(Post post);

    Like findByAuthorAndPost(User author, Post post);

}
