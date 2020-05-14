package ru.itis.socialnetworkboot.repository.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.socialnetworkboot.model.Album;
import ru.itis.socialnetworkboot.model.User;

import java.util.List;

public interface AlbumRepository extends JpaRepository<Album, Long> {

    List<Album> getAllByOwner(User user);

}
