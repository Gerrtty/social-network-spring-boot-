package ru.itis.rest.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "socialNetworkUser")
@ToString(exclude = "albums")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NotNull
    private String email;

    @NotNull
    private String firstName;

    @NotNull
    private String secondName;

    @NotNull
    private String password;

    private String lastName;
    private String phone;
    private String town;
    private Date birthDate;

    private String pathToAva;

    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Album> albums;

    private Integer confirmation;

    public User(Long userId) {
        this.userId = userId;
    }

}
