package ru.itis.socialnetworkboot.repository.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.socialnetworkboot.model.CommentForPhoto;
import ru.itis.socialnetworkboot.model.Photo;

import java.util.List;

public interface CommentsForPhotoRepository extends JpaRepository<CommentForPhoto, Long> {

    List<CommentForPhoto> findAllByPhoto(Photo photo);

}
