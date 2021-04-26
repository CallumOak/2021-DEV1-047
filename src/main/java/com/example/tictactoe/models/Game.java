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

    public Game(Player player1, Player player2, Board board){
        this.player1 = player1;
        this.player2 = player2;
        this.board = board;
        currentPlayerId = 1;
    }

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
