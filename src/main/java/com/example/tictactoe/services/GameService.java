package com.example.tictactoe.services;

import com.example.tictactoe.models.Game;
import org.springframework.stereotype.Service;

@Service
public interface GameService {
    Game getGame();
    void makeMove(String coordinates);
    Boolean validateMove(int location);
    String board();
    String gameStatus();
}
