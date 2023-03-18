package io.itmca.manito.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.concurrent.ThreadLocalRandom;

@Entity
@Getter
@NoArgsConstructor
public class Participant {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private ManitoGroup manitoGroup;
    private String name;
    private String nickName;
    private String secret;
    @OneToOne
    private Participant maro;
    private String guess;
    private String createdDate;
    private String modifiedDate;

    @Builder
    private Participant(String name, String nickName) {
        this.name = name;
        this.nickName = nickName;
        this.secret = "" + ThreadLocalRandom.current().nextInt();
    }

    public void guess(String guessedManito) {
        this.guess = guessedManito;
    }

    public void join(ManitoGroup manitoGroup) {
        this.manitoGroup = manitoGroup;
        this.manitoGroup.receive(this);
    }

    public void playManitoFor(Participant maro) {
        this.maro = maro;
    }
}
