package ru.itis.socialnetworkboot.repository.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.socialnetworkboot.model.Subscriptions;
import ru.itis.socialnetworkboot.model.User;

import java.util.List;

public interface SubscriptionsRepository extends JpaRepository<Subscriptions, Long> {

    List<Subscriptions> findAllByWho(User user);

    List<Subscriptions> findAllByOnWhom(User user);

}
