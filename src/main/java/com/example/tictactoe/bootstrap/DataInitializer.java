package com.example.tictactoe.bootstrap;

import com.example.tictactoe.models.Board;
import com.example.tictactoe.models.Game;
import com.example.tictactoe.models.Player;
import com.example.tictactoe.repositories.GameRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Order(1)
public class DataInitializer implements CommandLineRunner {
    private final GameRepository gameRepository;
    @Override
    public void run(String... args) throws Exception {
        Player player1 = new Player(1);
        Player player2 = new Player(2);
        Board board = new Board();
        Game game = new Game(player1, player2, board);
        gameRepository.save(game);
        System.out.println("\n\nInitialized\n\n");
    }
}
