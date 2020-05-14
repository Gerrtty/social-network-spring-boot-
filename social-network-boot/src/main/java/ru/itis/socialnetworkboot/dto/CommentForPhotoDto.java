package ru.itis.socialnetworkboot.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.socialnetworkboot.model.Comment;
import ru.itis.socialnetworkboot.model.CommentForPhoto;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentForPhotoDto {

    private Long photoId;
    private String text;
    private String firstName;
    private String secondName;

    private Long authorCommentId;

    public static CommentForPhotoDto from(CommentForPhoto comment) {

        return CommentForPhotoDto.builder()
                .photoId(comment.getPhoto().getPhotoId())
                .firstName(comment.getCommentAuthor().getFirstName())
                .secondName(comment.getCommentAuthor().getSecondName())
                .text(comment.getText())
                .authorCommentId(comment.getCommentAuthor().getUserId())
                .build();
    }

    public static List<CommentForPhotoDto> from(List<CommentForPhoto> comments) {
        return comments.stream()
                .map(CommentForPhotoDto::from)
                .collect(Collectors.toList());
    }
}