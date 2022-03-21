package com.vivo.jogodavelha.controller;

import com.vivo.jogodavelha.data.RequestMoveData;
import com.vivo.jogodavelha.models.Game;
import com.vivo.jogodavelha.repositories.GameRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;

@RestController
public class GameController {
    private final GameRepository repository;

    public GameController(GameRepository repository){
        this.repository = repository;
    }

    @PostMapping("/game")
    public Game newGame(){
        var game = new Game();
        return repository.save(game);
    }

    @PostMapping("/game/{id}/movement")
    public HashMap<String, String> move(@PathVariable Long id, @RequestBody RequestMoveData move) throws Exception {
        HashMap<String, String> answer = new HashMap<>();

        return answer;
    }
}


