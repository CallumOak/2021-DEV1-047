package com.example.tictactoe.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ElementCollection
    private List<Integer> grid = new ArrayList<>();
    @ElementCollection
    private List<Integer> victoryLines = new ArrayList<>();

    public Board(){
        for(int i = 0; i < 9; i++){
            grid.add(0);
        }
        for(int i = 0; i < 8; i++){
            victoryLines.add(0);
        }
    }

    /*
    The victory lines are the score of each horizontal, vertical,
    and diagonal line. Each x on a line corresponds to +1, and each o
    corresponds to -1.

    board :
    a    |   |
      ---+---+---
    b    |   |
      ---+---+---
    c    |   |
       0   1   2

    vicoryLines :
       3   4   5
    0    |   |
      ---+---+---
    1    |   |
      ---+---+---
    2    |   |
    7             6

    so when a0 is updated, the scores of lines 0, 3, 6 must be updated
     */
    public void setVictoryLines(int location, int value) {
        switch (location){
            case 0:
                victoryLines.set(0, (victoryLines.get(0) + value));
                victoryLines.set(3, (victoryLines.get(3) + value));
                victoryLines.set(6, (victoryLines.get(6) + value));
                break;
            case 1:
                victoryLines.set(0, (victoryLines.get(0) + value));
                victoryLines.set(4, (victoryLines.get(4) + value));
                break;

            case 2:
                victoryLines.set(0, (victoryLines.get(0) + value));
                victoryLines.set(5, (victoryLines.get(5) + value));
                victoryLines.set(7, (victoryLines.get(7) + value));
                break;
            case 3:
                victoryLines.set(1, (victoryLines.get(1) + value));
                victoryLines.set(3, (victoryLines.get(3) + value));
                break;

            case 4:
                victoryLines.set(1, (victoryLines.get(1) + value));
                victoryLines.set(4, (victoryLines.get(4) + value));
                victoryLines.set(6, (victoryLines.get(6) + value));
                victoryLines.set(7, (victoryLines.get(7) + value));
                break;

            case 5:
                victoryLines.set(1, (victoryLines.get(1) + value));
                victoryLines.set(5, (victoryLines.get(5) + value));
                break;

            case 6:
                victoryLines.set(2, (victoryLines.get(2) + value));
                victoryLines.set(3, (victoryLines.get(3) + value));
                victoryLines.set(7, (victoryLines.get(7) + value));
                break;
            case 7:
                victoryLines.set(2, (victoryLines.get(2) + value));
                victoryLines.set(4, (victoryLines.get(4) + value));
                break;
            case 8:
                victoryLines.set(2, (victoryLines.get(2) + value));
                victoryLines.set(5, (victoryLines.get(5) + value));
                victoryLines.set(6, (victoryLines.get(6) + value));
                break;

        }
    }

    @Override
    public String toString() {
        String boardString = "";

        for(int rowIndex = 0 ; rowIndex < 3; rowIndex++){
            for(int valueIndex = 0 ; valueIndex < 3; valueIndex++){
                String shape;
                switch (grid.get(rowIndex * 3 + valueIndex)){
                    case 1:
                        shape = " X";
                        break;
                    case -1:
                        shape = " O";
                        break;
                    default:
                        shape = "  ";
                        break;
                }
                String boardDrawing = valueIndex < 2 ? " |" : " " + (char) ('a' + rowIndex) + "\n";
                boardString += shape + boardDrawing;
            }
            String boardDrawing = rowIndex < 2 ? "---+---+---\n" : " 0   1   2";
            boardString += boardDrawing;
        }

        return boardString;
    }
}
