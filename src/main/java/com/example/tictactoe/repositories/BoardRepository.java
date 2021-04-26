package com.example.tictactoe.repositories;

import com.example.tictactoe.models.Board;
import org.springframework.data.repository.CrudRepository;

public interface BoardRepository extends CrudRepository<Board, Integer> {
}
