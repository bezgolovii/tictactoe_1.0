package com.example.tictactoe;

import java.util.Random;

public class ComputerPlayer extends Player {
    Random random = new Random();

    public ComputerPlayer(String name, char mark) {
        super(name, mark);
    }

    @Override
    public int makeMove(GameBoard board) {
        while (true) {
            int pos = random.nextInt(9);
            if (board.getCell(pos) == 0) return pos;
        }
    }
}