package com.vivo.jogodavelha.models;

import lombok.Data;


@Data
public class Movement {
    private int x, y;


    public boolean checkValidate() {
        return x >= 0 && x < 3 && y >= 0 && y < 3;
    }
}
