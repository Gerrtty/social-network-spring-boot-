package ru.itis.socialnetworkboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "commentForPhoto")
@ToString(exclude = "photo")
public class CommentForPhoto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentForPhotoId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "author_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User commentAuthor;

    @ManyToOne(fetch = FetchType.LAZY)
    private Photo photo;

    private String text;

}