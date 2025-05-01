package com.example.tictactoe;

import java.io.*;

public class GameBoard {
    private final byte[] board = new byte[3]; // Поле состоит из трех байтов

    public void setCell(int index, int value) throws IOException {
        if (index >= 0 && index <= 8 && value >= 0 && value <= 3) {
            int byteIndex = index / 3;   // Определяем индекс байта
            int bitShift = (index % 3) * 2; // Смещение внутри байта
            byte currentByte = this.board[byteIndex];
            currentByte &= ~(3 << bitShift); // Обнуляем два бита
            currentByte |= ((value & 3) << bitShift); // Устанавливаем новое значение
            this.board[byteIndex] = currentByte;
        }
    }

    public int getCell(int index) {
        if (index >= 0 && index <= 8) {
            int byteIndex = index / 3;
            int bitShift = (index % 3) * 2;
            return (this.board[byteIndex] >> bitShift) & 3;
        }
        throw new IndexOutOfBoundsException("Invalid cell index");
    }

    public boolean isFull() {
        for (int i = 0; i < 9; i++) {
            if (getCell(i) == 0) return false;
        }
        return true;
    }

    public void saveToFile(String filename) throws IOException {
        try (OutputStream os = new FileOutputStream(filename)) {
            os.write(this.board);
        }
    }

    public static GameBoard loadFromFile(String filename) throws IOException {
        GameBoard gameBoard = new GameBoard();
        try (InputStream is = new FileInputStream(filename)) {
            is.read(gameBoard.board);
        }
        return gameBoard;
    }
}