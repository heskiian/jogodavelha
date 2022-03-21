package com.vivo.jogodavelha.models;

import java.util.Random;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@JsonIgnoreProperties({ "status"})
public class Game {

    public enum Status {
        END_GAME, EXECUTING_GAME
    }

    @Id
    @GeneratedValue
    private long id;
    @Embedded
    private final Board board = new Board();
    private char actualPlayer;
    private Status status;

    public Game(){
        var random = new Random();
        this.actualPlayer = random.nextInt(2) > 0 ? 'X' : 'O';
        this.status = Status.EXECUTING_GAME;
    }

    public enum MoveRes {

        INVALID_MOVE,
        INVALID_PLAYER,
        INVALID_TURN,
        VALID,
        END,


    }


    public MoveRes executeMove(Movement move, Character player) {
        if (status == Status.END_GAME)
            return MoveRes.END;

        if (!move.checkValidate())
            return MoveRes.INVALID_MOVE;


        player = Character.toUpperCase(player);
        if (player != 'X' && player != 'O')
            return MoveRes.INVALID_PLAYER;
        if (!player.equals(actualPlayer))
            return MoveRes.INVALID_TURN;

        board.acceptMove(player, move);
        nextPlayer();
        return MoveRes.VALID;
    }


    @Nullable
    public Character getWinner() {
        if (board.getStatusWin()== Board.Status.DRAW)
            return null;
        else
            return board.getWinner();
    }


    public void nextPlayer() {
        actualPlayer = actualPlayer == 'X'? 'O' : 'X';
    }
}
