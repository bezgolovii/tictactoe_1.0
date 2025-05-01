package com.example.tictactoe;

public abstract class Player {
    protected String name;
    protected char mark; // 'X' or 'O'

    public Player(String name, char mark) {
        this.name = name;
        this.mark = mark;
    }

    public abstract int makeMove(GameBoard board);

    @Override
    public String toString() {
        return name + " (" + mark + ")";
    }
}