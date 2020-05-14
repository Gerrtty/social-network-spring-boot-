package ru.itis.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itis.rest.model.Post;

import java.util.List;

public interface PostsRepository extends JpaRepository<Post, Long> {

    List<Post> findBywhereIdOrderByDateDesc(Long id);

    @Query(value = "select p.* from post p join subscriptions" +
            " on p.author_id = subscriptions.on_whom_user_id where who_user_id = ?1 order by p.date desc",
    nativeQuery = true)
    List<Post> getSubPost(Long whoId);

}