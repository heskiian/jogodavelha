package com.vivo.jogodavelha.service.impl;

import com.vivo.jogodavelha.models.Game;
import com.vivo.jogodavelha.repositories.GameRepository;
import com.vivo.jogodavelha.service.AnswerService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DefaultAnswerService implements AnswerService {
    private final GameRepository repository;

    public DefaultAnswerService(GameRepository repository) {
        this.repository = repository;
    }


    @Override
    public void answerService(String answer) {

        Optional<Game> game = repository.findById(id);
        if (game.isEmpty()) {
            answer.put("msg", "Partida não encontrada");

        }

        var moveRes = game.map((p) -> p.executeMove(move.getPosition(), move.getPlayer()));
        switch (moveRes.orElse(Game.MoveRes.VALID)) {
            case VALID:
                game.map(repository::save);
                break;

            case INVALID_PLAYER:
                answer.put("msg", "Não foi possivel validar o jogador");
                break;
            case INVALID_MOVE:
                answer.put("msg", "Movimento solicitado invalido");
                break;

            case INVALID_TURN:
                answer.put("msg", "Não é turno do jogador");
                break;
            case END:
                game.map(repository::save);
                Optional<String> winner = game.map(p -> {
                    var v = p.getWinner();
                    if (v == null) {
                        return "Draw";
                    }
                    return v.toString().toUpperCase();
                });
                answer.put("msg", "Partida finalizada");
                answer.put("winner", winner.get());
                break;

        }
    }
}
