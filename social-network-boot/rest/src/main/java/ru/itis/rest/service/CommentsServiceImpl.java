package ru.itis.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.rest.dto.CommentDto;
import ru.itis.rest.model.Comment;
import ru.itis.rest.model.Post;
import ru.itis.rest.model.User;
import ru.itis.rest.repository.CommentsRepository;

import java.util.List;

@Service
public class CommentsServiceImpl {

    private final CommentsRepository commentsRepository;

    @Autowired
    public CommentsServiceImpl(CommentsRepository commentsRepository) {
        this.commentsRepository = commentsRepository;
    }

    public void addComment(CommentDto commentDto, User user) {

        Comment comment = Comment.builder()
                .commentAuthor(user)
                .post(new Post(commentDto.getPostId()))
                .text(commentDto.getText())
                .build();

        commentsRepository.save(comment);

    }

    public List<CommentDto> getComments(Long postId, Integer page) {

        Post post = new Post(postId);

        return CommentDto.from(commentsRepository.findAllByPost(post));
    }

}
