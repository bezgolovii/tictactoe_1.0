package com.example.tictactoe;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        GameBoard board = new GameBoard();
        Player player1 = new HumanPlayer("User", 'X');
        Player player2 = new ComputerPlayer("AI", 'O');

        printBoard(board);

        while (!isGameOver(board)) {
            playTurn(player1, board);
            printBoard(board);
            if (isGameOver(board)) break;
            playTurn(player2, board);
            printBoard(board);
        }

        // Сохраняем состояние игрового поля в файл
        board.saveToFile("gamestate.bin");
    }

    private static void playTurn(Player player, GameBoard board) {
        int position = player.makeMove(board);
        try {
            board.setCell(position, player.mark == 'X' ? 1 : 2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isGameOver(GameBoard board) {
        return checkWin(board, 1) || checkWin(board, 2) || board.isFull();
    }

    private static boolean checkWin(GameBoard board, int playerMark) {
        // Проверка всех возможных комбинаций выигрыша
        int[][] winCombinations = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8},
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
                {0, 4, 8}, {2, 4, 6}};
        for (int[] combination : winCombinations) {
            if (board.getCell(combination[0]) == playerMark &&
                    board.getCell(combination[1]) == playerMark &&
                    board.getCell(combination[2]) == playerMark) {
                return true;
            }
        }
        return false;
    }

    private static void printBoard(GameBoard board) {
        System.out.println("Current Board:");
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                int cellValue = board.getCell(row * 3 + col);
                switch (cellValue) {
                    case 0:
                        System.out.print(" . "); break;
                    case 1:
                        System.out.print(" X "); break;
                    case 2:
                        System.out.print(" O "); break;
                }
            }
            System.out.println();
        }
    }
}