package com.example.tictactoe.repositories;

import com.example.tictactoe.models.Player;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<Player, Integer> {
}
