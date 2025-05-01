package com.example.tictactoe;

import java.util.Scanner;

public class HumanPlayer extends Player {
    public HumanPlayer(String name, char mark) {
        super(name, mark);
    }

    @Override
    public int makeMove(GameBoard board) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your move (0-8): ");
        return Integer.parseInt(scanner.nextLine());
    }
}