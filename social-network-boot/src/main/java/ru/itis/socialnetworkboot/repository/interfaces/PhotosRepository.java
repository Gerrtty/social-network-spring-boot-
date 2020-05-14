package ru.itis.socialnetworkboot.repository.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ru.itis.socialnetworkboot.model.Album;
import ru.itis.socialnetworkboot.model.Photo;

import java.util.List;

public interface PhotosRepository extends JpaRepository<Photo, Long> {

    List<Photo> findAllByAlbum(Album album);

    @Modifying
    @Query("update Photo p set p.latitude = ?1, p.longitude = ?2 where p.photoId = ?3")
    void setLocation(Float lat, Float lgt, Long id);

}
