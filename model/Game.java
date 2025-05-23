package model;

public class Game {
    
    Player player1;
    Player player2;

    Board board;
    boolean isGameOver;
    boolean isWinner;
    boolean isDraw;
    int currentPlayerIndex;
    int totalMoves;

    public Game(Player player1, Player player2, Board board) {
        this.player1 = player1;
        this.player2 = player2;
        this.board = board;
        this.isGameOver = false;
        this.isWinner = false;
        this.isDraw = false;
        this.currentPlayerIndex = 0; // Start with player1
        this.totalMoves = 0;
    }
    Boolean isGameOver() {
        return isGameOver;
    }
    Boolean isWinner() {
        return isWinner;
    }
    Boolean isDraw() {
        return isDraw;
    }
    public void makeMove(Player player, int row, int col) {
        if (isGameOver) {
            System.out.println("Game is already over.");
            return;
        }
        if (isCellEmpty(row, col)) {
            board.setCell(row, col, player.getSymbol());
            totalMoves++;
            if (board.checkWin(player.getSymbol())) {
                isWinner = true;
                isGameOver = true;
                System.out.println("Player " + player.getPersonalDetails().getName() + " wins!");
            } else if (totalMoves == board.getSize() * board.getSize()) {
                isDraw = true;
                isGameOver = true;
                System.out.println("It's a draw!");
            } else {
                currentPlayerIndex = (currentPlayerIndex + 1) % 2; // Switch players
            }
        } else {
            System.out.println("Cell already occupied. Try again.");
        }
    }
    public boolean isCellEmpty(int row, int col) {
        String cell = board.getCell(row, col);
        return cell.equals(Symbol.START.getSymbol());
    }
    public void startGame() {
        String player1name = player1.getPersonalDetails().getName();
        String player2name = player2.getPersonalDetails().getName();
        System.out.println("Game started between " + player1name + " and " + player2name);
        System.out.println("Player 1: " + player1.getSymbol());
        System.out.println("Player 2: " + player2.getSymbol());
        System.out.println("Current Board:");
        board.printBoard();
        System.out.println("Player " + (currentPlayerIndex + 1) + "'s turn");
    }
}
