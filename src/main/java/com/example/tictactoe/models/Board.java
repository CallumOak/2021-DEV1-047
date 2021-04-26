package com.example.tictactoe.models;

import java.util.ArrayList;
import java.util.List;

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
}
