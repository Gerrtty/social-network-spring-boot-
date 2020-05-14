package ru.itis.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.rest.model.Album;
import ru.itis.rest.model.User;
import ru.itis.rest.repository.AlbumRepository;
import java.util.List;

@Service
public class AlbumsServiceImpl {

    private final AlbumRepository albumRepository;

    @Autowired
    public AlbumsServiceImpl(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }


    public void createAlbum(User user, String title) {

        Album album = Album.builder()
                .owner(user)
                .title(title)
                .build();


        albumRepository.save(album);

    }

    public List<Album> getAllByUser(User authUser, Long userId) {

        if(!authUser.getUserId().equals(userId)) {
            return albumRepository.getAllByOwner(new User(userId));
        }

        else {
            return albumRepository.getAllByOwner(authUser);
        }
    }

}
