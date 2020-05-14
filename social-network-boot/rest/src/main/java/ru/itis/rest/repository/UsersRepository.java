package ru.itis.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ru.itis.rest.model.User;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    Optional<User> findByUserId(long id);

    @Modifying
    @Query("update User u set u.pathToAva = ?1 where u.userId = ?2")
    void updatePathToAvaByUserId(String path, Long id);

    @Modifying
    @Query("update User u set u.confirmation = 1 where u.userId = ?1")
    void setConfirmFlag(Long id);

}
