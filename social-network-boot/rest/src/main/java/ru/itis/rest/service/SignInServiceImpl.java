package ru.itis.rest.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.rest.dto.SignInDto;
import ru.itis.rest.dto.SignUpDto;
import ru.itis.rest.dto.TokenDto;
import ru.itis.rest.model.User;
import ru.itis.rest.repository.UsersRepository;

import java.nio.file.AccessDeniedException;
import java.util.Optional;

@Service
public class SignInServiceImpl {

    @Value("${jwt.secret}")
    private String secret;

    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    public SignInServiceImpl(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public TokenDto signIn(SignInDto signInData) throws AccessDeniedException {
        Optional<User> optionalUser = usersRepository.findByEmail(signInData.getEmail());

        if(optionalUser.isPresent()) {

            User user = optionalUser.get();

            if(passwordEncoder.matches(signInData.getPassword(), user.getPassword())) {

                String token = Jwts.builder()
                        .setSubject(user.getUserId().toString())
                        .claim("email", user.getEmail())
//                        .claim("role", user.getRole())
                        .signWith(SignatureAlgorithm.HS256, secret)
                        .compact();

                return new TokenDto(token);

            }

            else {

                throw new AccessDeniedException("Wrong email/password");

            }

        }

        else throw new AccessDeniedException("User not found");
    }

    public User signUp(SignUpDto signUpDto) {

        User user = User.builder()
                .email(signUpDto.getEmail())
                .password(passwordEncoder.encode(signUpDto.getPassword()))
//                .role(Role.USER)
                .build();

        user = usersRepository.save(user);

        return user;

    }

}