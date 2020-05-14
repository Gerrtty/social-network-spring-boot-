package ru.itis.socialnetworkboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AjaxResponseBody {

    String msg;
    List<UsersDto> result;

}