package com.example.tictactoe.services;

import com.example.tictactoe.models.Game;
import com.example.tictactoe.repositories.GameRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;

    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public Game getGame() {
        return ((ArrayList<Game>) gameRepository.findAll()).get(0);
    }

    @Override
    public String makeMove(String coordinates) {
        int row = coordinates.charAt(0) - 'a';
        int column = Integer.parseInt(coordinates.substring(1));
        int location = row * 3 + column;
        if(validateInputs(row, column) && validateMove(location)){
            Game game = getGame();
            int value = game.getCurrentPlayerId() == 1 ? 1 : -1;
            game.getBoard().getGrid().set(location, value);
            game.getBoard().setVictoryLines(location, value);
            game.setCurrentPlayerId(game.getCurrentPlayerId() == 1 ? 2 : 1);
            game.setGameStatus();
            gameRepository.save(game);
            return "Good move";
        }
        return "INVALID MOVE " + coordinates;
    }

    @Override
    public Boolean validateMove(int location) {
        if(location >= 0 && location < 9){
            return getGame().getBoard().getGrid().get(location) == 0;
        }
        else{
            throw new IndexOutOfBoundsException("Invalid input " + location);
        }
    }

    @Override
    public Boolean validateInputs(int row, int column) {
        return row <3 && row >=0 && column <3;
    }

    @Override
    public String board() {
        return getGame().getBoard().toString();
    }

    @Override
    public String gameStatus() {
        return getGame().getGameStatus().toString();
    }
}
