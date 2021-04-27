package com.example.tictactoe.services;

import com.example.tictactoe.models.Game;
import org.springframework.stereotype.Service;

@Service
public interface GameService {
    Game getGame();
    String makeMove(String coordinates);
    Boolean validateMove(int location);
    Boolean validateInputs(int row, int column);
    String board();
    String gameStatus();
}
