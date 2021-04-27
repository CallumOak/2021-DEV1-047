package com.example.tictactoe.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToOne(cascade = CascadeType.ALL)
    private Player player1;
    @OneToOne(cascade = CascadeType.ALL)
    private Player player2;
    private Integer currentPlayerId;
    @OneToOne(cascade = CascadeType.ALL)
    private Board board;
    @Enumerated(EnumType.STRING)
    private TwoPlayerGameStatusEnum gameStatus = TwoPlayerGameStatusEnum.ONGOING;

    public Game(Player player1, Player player2, Board board){
        this.player1 = player1;
        this.player2 = player2;
        this.board = board;
        currentPlayerId = 1;
    }

    public void setGameStatus() {
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
