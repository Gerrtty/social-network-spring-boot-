package ru.itis.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.rest.model.CommentForPhoto;
import ru.itis.rest.model.Photo;

import java.util.List;

public interface CommentsForPhotoRepository extends JpaRepository<CommentForPhoto, Long> {

    List<CommentForPhoto> findAllByPhoto(Photo photo);

}
