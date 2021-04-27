package com.example.tictactoe.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
    }

    @Test
    void setVictoryLines() {
        assertEquals(board.getVictoryLines(), new ArrayList<>(Arrays.asList(0,0,0,0,0,0,0,0)));
        board.setVictoryLines(0,1);
        assertEquals(board.getVictoryLines(), new ArrayList<>(Arrays.asList(1,0,0,1,0,0,1,0)));
        board.setVictoryLines(1,-1);
        assertEquals(board.getVictoryLines(), new ArrayList<>(Arrays.asList(0,0,0,1,-1,0,1,0)));
    }

    @Test
    void setGrid() {
        assertEquals(board.getVictoryLines(), new ArrayList<>(Arrays.asList(0,0,0,0,0,0,0,0)));
        assertEquals(board.getGrid(), new ArrayList<>(Arrays.asList(0,0,0,0,0,0,0,0,0)));
        board.setGrid(0, 1);
        assertEquals(board.getVictoryLines(), new ArrayList<>(Arrays.asList(1,0,0,1,0,0,1,0)));
        assertEquals(board.getGrid(), new ArrayList<>(Arrays.asList(1,0,0,0,0,0,0,0,0)));
    }

    @Test
    void testToString() {
        board.setGrid(0, 1);
        board.setGrid(1, 1);
        board.setGrid(2, 1);
        board.setGrid(3, -1);
        board.setGrid(5, -1);
        board.setGrid(6, -1);

        String boardRepresentation =
                " X | X | X a\n" +
                "---+---+---\n" +
                " O |   | O b\n" +
                "---+---+---\n" +
                " O |   |   c\n" +
                " 0   1   2";

        assertEquals(board.toString(), boardRepresentation);
    }
}