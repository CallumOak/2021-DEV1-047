package com.example.tictactoe.controllers;

import com.example.tictactoe.services.GameService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
@Order(2)
public class GameController implements CommandLineRunner {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        while(gameService.gameStatus() == "ONGOING"){
            printTurn("\nPlease enter the coordinates : ");
            String coordinates = scanner.nextLine();
            gameService.makeMove(coordinates);
        }
        if(gameService.gameStatus() == "DRAW"){
            printTurn("It's a draw. Nobody won...");
        }
        else{
            printTurn("CONGRATULATIONS " + gameService.gameStatus() + ", YOU WIN!!!");
        }
    }

    private void printTurn(String text){
        System.out.println(gameService.board());
        System.out.println(text);
    }
}
