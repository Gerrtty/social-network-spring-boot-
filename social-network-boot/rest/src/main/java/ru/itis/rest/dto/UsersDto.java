package ru.itis.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.rest.model.User;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsersDto {

    private Long userId;
    private String firstName;
    private String secondName;

    public static UsersDto from(User user) {

        return UsersDto.builder()
                .firstName(user.getFirstName())
                .secondName(user.getSecondName())
                .userId(user.getUserId())
                .build();

    }

    public static List<UsersDto> from(List<User> users) {
        return users.stream()
                .map(UsersDto::from)
                .collect(Collectors.toList());
    }

}
