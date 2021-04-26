package com.example.tictactoe.controllers;

import com.example.tictactoe.services.GameService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class GameController implements CommandLineRunner {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner input = new Scanner(System.in);
        while(gameService.gameStatus() == "ONGOING"){
            System.out.println(gameService.board());
            System.out.println("\nPlease enter the coordinates : ");
            String coordinates = input.nextLine();
            gameService.makeMove(coordinates);
        }
        if(gameService.gameStatus() == "DRAW"){
            System.out.println(gameService.board());
            System.out.println("It's a draw. Nobody won...");
        }
        else{
            System.out.println(gameService.board());
            System.out.println("CONGRATULATIONS " + gameService.gameStatus() + ", YOU WIN!!!");
        }
    }
}
