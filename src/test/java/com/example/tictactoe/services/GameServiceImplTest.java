package com.example.tictactoe.services;

import com.example.tictactoe.models.Board;
import com.example.tictactoe.models.Game;
import com.example.tictactoe.models.Player;
import com.example.tictactoe.repositories.GameRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class GameServiceImplTest {
    @Mock
    GameRepository gameRepository;
    GameServiceImpl gameService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        gameService = new GameServiceImpl(gameRepository);
        Player player1 = new Player(1);
        Player player2 = new Player(2);
        Board board = new Board();
        Game game = new Game(player1, player2, board);
        when(gameRepository.findAll()).thenReturn(new ArrayList<>(Arrays.asList(game)));
    }

    @Test
    void makeMove() {
        assertEquals (gameService.makeMove("a0"),"Good move");
        assertEquals (gameService.makeMove("a0"), "ALREADY OCCUPIED a0");
        assertEquals (gameService.makeMove("a5"),"INVALID COORDINATES a5");
        assertEquals (gameService.makeMove("a1"),"Good move");
        assertEquals (gameService.makeMove("b0"),"Good move");
        assertEquals (gameService.makeMove("b1"),"Good move");
        assertEquals (gameService.makeMove("c0"),"Good move");
    }

    @Test
    void validateMove() {
        IndexOutOfBoundsException exception = assertThrows(
                IndexOutOfBoundsException.class, () -> gameService.validateMove(10)
        );
        assertEquals(exception.getMessage(), "Invalid input 10");
        exception = assertThrows(
                IndexOutOfBoundsException.class, () -> gameService.validateMove(-1)
        );
        assertEquals(exception.getMessage(), "Invalid input -1");
        assertTrue(gameService.validateMove(0));
        assertTrue(gameService.validateMove(1));
        assertTrue(gameService.validateMove(2));
        assertTrue(gameService.validateMove(3));
        assertTrue(gameService.validateMove(4));
        assertTrue(gameService.validateMove(5));
        assertTrue(gameService.validateMove(6));
        assertTrue(gameService.validateMove(7));
        assertTrue(gameService.validateMove(8));
    }

    @Test
    void validateInputs() {
        assertTrue(gameService.validateInputs("a0"));
        assertTrue(gameService.validateInputs("a1"));
        assertTrue(gameService.validateInputs("a2"));
        assertTrue(gameService.validateInputs("b0"));
        assertTrue(gameService.validateInputs("b1"));
        assertTrue(gameService.validateInputs("b2"));
        assertTrue(gameService.validateInputs("c0"));
        assertTrue(gameService.validateInputs("c1"));
        assertTrue(gameService.validateInputs("c2"));

        assertFalse(gameService.validateInputs("a3"));
        assertFalse(gameService.validateInputs("b3"));
        assertFalse(gameService.validateInputs("c3"));
        assertFalse(gameService.validateInputs("aa"));
        assertFalse(gameService.validateInputs("11"));
        assertFalse(gameService.validateInputs("a11"));
        assertFalse(gameService.validateInputs("a"));
    }
}