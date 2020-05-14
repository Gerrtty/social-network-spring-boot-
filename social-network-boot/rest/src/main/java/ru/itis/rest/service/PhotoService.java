package ru.itis.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.rest.dto.PhotoDto;
import ru.itis.rest.dto.UploadForm;
import ru.itis.rest.model.Album;
import ru.itis.rest.model.Photo;
import ru.itis.rest.model.User;
import ru.itis.rest.repository.PhotosRepository;

import java.util.List;

@Service
public class PhotoService {

    private final PhotosRepository photosRepository;

    @Autowired
    public PhotoService(PhotosRepository photosRepository) {
        this.photosRepository = photosRepository;
    }

    public void setPhoto(UploadForm uploadForm, String url) {
        Photo photo = Photo.builder()
                .album(new Album(uploadForm.getAlbumId()))
                .owner(new User(uploadForm.getUserId()))
                .url(url)
                .build();

        photosRepository.save(photo);

    }

    public List<PhotoDto> getAlbumsPhotos(Long albumId) {

        return PhotoDto.from(photosRepository.findAllByAlbum(new Album(albumId)));
    }

}
