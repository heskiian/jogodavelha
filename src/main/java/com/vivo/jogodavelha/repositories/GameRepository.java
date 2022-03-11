package com.vivo.jogodavelha.repositories;

import com.vivo.jogodavelha.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
