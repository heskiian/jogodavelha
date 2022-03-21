package com.vivo.jogodavelha.data;

import lombok.Data;

@Data
public class RequestMoveData {
    private Character player;
    private MovimentData position;
}
