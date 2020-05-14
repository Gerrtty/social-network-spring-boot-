package ru.itis.socialnetworkboot.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.socialnetworkboot.model.Comment;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {

    private Long postId;
    private String text;
    private String firstName;
    private String secondName;

    private Long authorCommentId;

    public static CommentDto from(Comment comment) {

        return CommentDto.builder()
                .postId(comment.getPost().getPostId())
                .firstName(comment.getCommentAuthor().getFirstName())
                .secondName(comment.getCommentAuthor().getSecondName())
                .text(comment.getText())
                .authorCommentId(comment.getCommentAuthor().getUserId())
                .build();
    }

    public static List<CommentDto> from(List<Comment> comments) {
        return comments.stream()
                .map(CommentDto::from)
                .collect(Collectors.toList());
    }
}