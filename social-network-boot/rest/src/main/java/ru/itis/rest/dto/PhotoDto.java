package ru.itis.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.rest.model.Photo;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PhotoDto {

    private Long photoId;
    private Long albumId;
    private String ownerEmail;
    private String ownerFirstName;
    private String ownerSecondName;
    private String url;
    private String albumTitle;


    public static PhotoDto from(Photo photo) {

        return PhotoDto.builder()
                .albumId(photo.getAlbum().getAlbumId())
                .photoId(photo.getPhotoId())
                .ownerEmail(photo.getOwner().getEmail())
                .ownerFirstName(photo.getOwner().getFirstName())
                .ownerSecondName(photo.getOwner().getSecondName())
                .url(photo.getUrl())
                .albumTitle(photo.getAlbum().getTitle())
                .build();
    }

    public static List<PhotoDto> from(List<Photo> photos) {

        return photos.stream()
                .map(PhotoDto::from)
                .collect(Collectors.toList());
    }

}
