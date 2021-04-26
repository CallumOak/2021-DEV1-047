package com.example.tictactoe.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.ElementCollection;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Board {
    private Integer id;
    private List<Integer> grid = new ArrayList<>();
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
}
