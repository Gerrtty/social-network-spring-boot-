package ru.itis.socialnetworkboot.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "dialog")
public class Dialog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dialogId;

    @NotNull
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.EAGER)
    private User user1;

    @NotNull
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.EAGER)
    private User user2;

    @ToString.Exclude
    @OneToMany(mappedBy = "dialog", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Message> messages;

    public Dialog(Long dialogId) {
        this.dialogId = dialogId;
    }

}
