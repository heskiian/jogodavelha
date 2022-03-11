package com.vivo.jogodavelha.controller;

import com.vivo.jogodavelha.models.Game;
import com.vivo.jogodavelha.repositories.GameRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {
    private final GameRepository repository;

    public GameController(GameRepository repository){
        this.repository = repository;
    }

    @PostMapping("/game")
    public Game newGame(){
        var game = newGame();
        return repository.save(game);
    }
}
