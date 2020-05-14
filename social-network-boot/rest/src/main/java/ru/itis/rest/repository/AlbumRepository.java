package ru.itis.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.rest.model.Album;
import ru.itis.rest.model.User;

import java.util.List;

public interface AlbumRepository extends JpaRepository<Album, Long> {

    List<Album> getAllByOwner(User user);

}
