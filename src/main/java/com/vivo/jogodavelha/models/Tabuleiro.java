package com.vivo.jogodavelha.models;


public class Tabuleiro {
    private final char[][] tabuleiro;


    public Tabuleiro() {
        this.tabuleiro = new char[3][3];
        for (int i = 0; i < 3; i++)
            for (int k = 0; k < 3; k++)
                this.tabuleiro[i][k] = ' ';
    }

}