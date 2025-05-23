package model;

public class Board {
    
    private String[][] board;
    private int size;

    public Board(int size) {
        this.size = size;
        this.board = new String[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = Symbol.START.getSymbol();
            }
        }
    }
    
    public String getCell(int row, int col) {
        return board[row][col];
    }
    public void setCell(int row, int col, String symbol) {
        board[row][col] = symbol;
    }

    public int getSize() {
        return size;
    }
    public boolean isFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j].equals(Symbol.START.getSymbol())) {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean checkWin(String symbol) {
        // Check rows
        for (int i = 0; i < size; i++) {
            boolean win = true;
            for (int j = 0; j < size; j++) {
                if (!board[i][j].equals(symbol)) {
                    win = false;
                    break;
                }
            }
            if (win) return true;
        }

        // Check columns
        for (int j = 0; j < size; j++) {
            boolean win = true;
            for (int i = 0; i < size; i++) {
                if (!board[i][j].equals(symbol)) {
                    win = false;
                    break;
                }
            }
            if (win) return true;
        }

        // Check diagonals
        boolean win = true;
        for (int i = 0; i < size; i++) {
            if (!board[i][i].equals(symbol)) {
                win = false;
                break;
            }
        }
        if (win) return true;

        win = true;
        for (int i = 0; i < size; i++) {
            if (!board[i][size - 1 - i].equals(symbol)) {
                win = false;
                break;
            }
        }
        return win;
    }
    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    public void resetBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = Symbol.START.getSymbol();
            }
        }
    }
    public void setBoard(String[][] board) {
        this.board = board;
    }
    public String[][] getBoard() {
        return board;
    }
    public void setSize(int size) {
        this.size = size;
    }
}
