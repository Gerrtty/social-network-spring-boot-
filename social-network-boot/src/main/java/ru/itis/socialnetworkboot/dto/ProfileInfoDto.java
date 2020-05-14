package ru.itis.socialnetworkboot.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfileInfoDto {

    private String firstName;
    private String secondName;
    private Date birthDate;
    private String town;

    private String pathToAva;

    private List<PostDto> posts;
}
