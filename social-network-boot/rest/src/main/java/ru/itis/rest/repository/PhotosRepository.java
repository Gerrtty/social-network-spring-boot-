package ru.itis.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.rest.model.Album;
import ru.itis.rest.model.Photo;

import java.util.List;

public interface PhotosRepository extends JpaRepository<Photo, Long> {

    List<Photo> findAllByAlbum(Album album);

}
