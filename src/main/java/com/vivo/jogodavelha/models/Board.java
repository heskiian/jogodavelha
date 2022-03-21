package com.vivo.jogodavelha.models;


import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
public class Board {
    private final char[][] board;

    @Getter
    private Status statusWin;
    @Getter
    private Character winner;


    public enum Status {
        EXECUTING, WIN, DRAW
    }


    public Board() {
        this.board = new char[3][3];
        statusWin = Status.EXECUTING;
        for (int i = 0; i < 3; i++)
            for (int k = 0; k < 3; k++)
                this.board[i][k] = ' ';
    }


    public void acceptMove(Character player, Movement move) {
        board[move.getX()][move.getY()] = player;
        refreshStatus();
    }

    private void refreshStatus() {

        for (int x = 0; x < 3; x++) {
            if (board[x][0] == board[x][1] && board[x][1] == board[x][2] && board[x][0] != ' ') {
                setWinner(board[x][0]);
                return;
            }
        }

        for (int y = 0; y < 3; y++) {
            if (board[0][y] == board[1][y] && board[1][y] == board[2][y] && board[0][y] != ' ') {
                setWinner(board[0][y]);
                return;
            }
        }


        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ') {
            setWinner(board[0][0]);
            return;
        }


        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' ') {
            setWinner(board[0][2]);
            return;
        }


        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (board[x][y] == ' ') {
                    statusWin = Status.EXECUTING;
                    return;
                }
            }
        }
        statusWin = Status.DRAW;
    }


    private void setWinner(char player) {
        statusWin = Status.WIN;
        winner = player;

    }
}