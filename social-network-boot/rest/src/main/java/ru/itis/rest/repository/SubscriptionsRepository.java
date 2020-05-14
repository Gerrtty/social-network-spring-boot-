package ru.itis.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.rest.model.Subscriptions;
import ru.itis.rest.model.User;

import java.util.List;

public interface SubscriptionsRepository extends JpaRepository<Subscriptions, Long> {

    List<Subscriptions> findAllByWho(User user);

    List<Subscriptions> findAllByOnWhom(User user);

}
