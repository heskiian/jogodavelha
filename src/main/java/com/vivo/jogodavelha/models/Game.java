package com.vivo.jogodavelha.models;

import java.util.Random;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Game {

    @Id
    @GeneratedValue
    private long id;
    private final Tabuleiro tabuleiro = new Tabuleiro();
    private char actualPlayer;

    public Game(){
        var random = new Random();
        this.actualPlayer = random.nextInt(2) > 0 ? 'X' : 'O';
    }
}
