package ru.itis.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegistrationDto {

    private String firstName;
    private String secondName;

    @Email(message = "Введён некорректный email")
    private String email;

    @Min(value = 3, message = "Пароль должен состоять минимум из 3х символов")
    private String password;

}
