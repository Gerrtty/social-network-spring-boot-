package ru.itis.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.rest.dto.PostDto;
import ru.itis.rest.repository.PostsRepository;
import ru.itis.rest.repository.SubscriptionsRepository;
import ru.itis.rest.model.Post;
import ru.itis.rest.model.Subscriptions;
import ru.itis.rest.model.User;

import java.util.List;

@Service
public class SubscribersServiceImpl {

    private final SubscriptionsRepository subscriptionsRepository;
    private final PostsRepository postsRepository;
    private final PostServiceImpl postService;

    @Autowired
    public SubscribersServiceImpl(SubscriptionsRepository subscriptionsRepository,
                                  PostsRepository postsRepository,
                                  PostServiceImpl postService) {
        this.subscriptionsRepository = subscriptionsRepository;
        this.postsRepository = postsRepository;
        this.postService = postService;
    }

    // все подписки
    public List<Subscriptions> getSubscriptions(User user) {
        return subscriptionsRepository.findAllByWho(user);
    }

    // все подписчики
    public List<Subscriptions> getSubscribers(User user) {
        return subscriptionsRepository.findAllByOnWhom(user);
    }

    public void subscribe(User who, User onWhom) {
        subscriptionsRepository.save(new Subscriptions(who, onWhom));
    }

    public List<PostDto> getPosts(Long whoId) {

        List<Post> posts = postsRepository.getSubPost(whoId);

        return postService.getPostsWithLike(posts);

    }

}
