package ru.itis.socialnetworkboot.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class SearchCriteria {

    @NotBlank(message = "username can't empty!")
    private String username;

}