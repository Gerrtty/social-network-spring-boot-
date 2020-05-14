package ru.itis.rest.service;

import org.springframework.stereotype.Service;
import ru.itis.rest.dto.CommentForPhotoDto;
import ru.itis.rest.model.CommentForPhoto;
import ru.itis.rest.model.Photo;
import ru.itis.rest.model.User;
import ru.itis.rest.repository.CommentsForPhotoRepository;
import java.util.List;

@Service
public class CommentForPhotoServiceImpl {

    private final CommentsForPhotoRepository commentsForPhotoRepository;

    public CommentForPhotoServiceImpl(CommentsForPhotoRepository commentsForPhotoRepository) {
        this.commentsForPhotoRepository = commentsForPhotoRepository;
    }

    public void leaveComment(User user, Long photoId, String text) {

        CommentForPhoto commentForPhoto = CommentForPhoto.builder()
                .commentAuthor(user)
                .photo(new Photo(photoId))
                .text(text)
                .build();

        commentsForPhotoRepository.save(commentForPhoto);
    }

    public List<CommentForPhotoDto> getComments(Long photoId) {
        return CommentForPhotoDto.from(commentsForPhotoRepository.findAllByPhoto(new Photo(photoId)));
    }

}
