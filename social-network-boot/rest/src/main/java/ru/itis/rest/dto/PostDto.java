package ru.itis.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.rest.model.Post;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostDto {

    private Long postId;
    private String text;
    private Date date;
    private String authorFirstName;
    private String authorSecondName;

    private Long countOfLikes;

    private List<CommentDto> comments;

    private Long pageId;

    public static PostDto from(Post post) {

        return PostDto.builder()
                .authorFirstName(post.getAuthor().getFirstName())
                .authorSecondName(post.getAuthor().getSecondName())
                .text(post.getText())
                .postId(post.getPostId())
                .date(post.getDate())
                .pageId(post.getWhereId())
                .build();
    }

    public static List<PostDto> from(List<Post> posts) {
        return posts.stream()
                .map(PostDto::from)
                .collect(Collectors.toList());
    }

}
