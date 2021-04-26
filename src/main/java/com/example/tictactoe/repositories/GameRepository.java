package com.example.tictactoe.repositories;

import com.example.tictactoe.models.Game;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<Game, Integer> {
}
