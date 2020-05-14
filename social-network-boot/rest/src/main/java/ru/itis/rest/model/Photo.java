package ru.itis.rest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "photo")
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long photoId;

    private String storageFileName;

    private String originalFileName;

    private Long size;
    // file type (MIME)
    private String type;
    // at what URL can I get the file
    private String url;

    @ManyToOne(fetch = FetchType.LAZY)
    private Album album;

    @ManyToOne(fetch = FetchType.LAZY)
    private User owner;

    public Photo(Long photoId) {
        this.photoId = photoId;
    }

}
