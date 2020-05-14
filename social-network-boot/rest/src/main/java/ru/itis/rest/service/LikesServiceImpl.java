package ru.itis.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.rest.model.Like;
import ru.itis.rest.model.Post;
import ru.itis.rest.model.User;
import ru.itis.rest.repository.LikesRepository;

@Service
public class LikesServiceImpl {

    private final LikesRepository likesRepository;

    @Autowired
    public LikesServiceImpl(LikesRepository likesRepository) {
        this.likesRepository = likesRepository;
    }

    public void saveLike(Long postId, User authUser) {
        Post post = new Post(postId);

        Like exists = likesRepository.findByAuthorAndPost(authUser, post);

        if(exists != null) {
            likesRepository.delete(exists);
        }

        else {
            likesRepository.save(Like.builder().post(post).author(authUser).build());
        }
    }

}
