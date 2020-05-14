package ru.itis.socialnetworkboot.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "subscriptions")
public class Subscriptions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subscriptionId;

    @ManyToOne(fetch = FetchType.LAZY)
    private User who;

    @ManyToOne(fetch = FetchType.LAZY)
    private User onWhom;

    public Subscriptions(User who, User onWhom) {
        this.who = who;
        this.onWhom = onWhom;
    }

}
