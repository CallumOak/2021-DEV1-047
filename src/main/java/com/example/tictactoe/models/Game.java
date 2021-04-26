package com.example.tictactoe.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Game {
    private Player player1;
    private Player player2;
    private Integer currentPlayerId;
    private Board board;
    private TwoPlayerGameStatusEnum gameStatus;

    public void setTwoPlayerGameStatusEnum() {
        if(board.getVictoryLines().contains(3)){
            gameStatus = TwoPlayerGameStatusEnum.PLAYER1;
            return;
        }
        if(board.getVictoryLines().contains(-3)){
            gameStatus = TwoPlayerGameStatusEnum.PLAYER2;
            return;
        }
        if(!board.getGrid().contains(0)){
            gameStatus = TwoPlayerGameStatusEnum.DRAW;
            return;
        }
        gameStatus =  TwoPlayerGameStatusEnum.ONGOING;
    }
}
