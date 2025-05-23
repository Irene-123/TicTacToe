// https://medium.com/@avinashsoni9829/tic-tac-toe-low-level-design-f7ebefa88efc

package model;

import java.util.Scanner;

public class TicTacToeDemo {
    public static void main(String[] args) {
        Board board = new Board(3);
        Scanner scanner = new Scanner(System.in);

        Player player1 = new Player(new PersonalDetails("Alice", "alice@gmail.com"), "X");
        Player player2 = new Player(new PersonalDetails("Bob", "bob@gmail.com"), "O");
        Game game = new Game(player1, player2, board);
        game.startGame();

        while (!game.isGameOver() && (!game.isWinner() || !game.isDraw())) {
            // Player 1's turn
            System.out.print("Player 1 - Enter row (0-2): ");
            int row = scanner.nextInt();
            System.out.print("Player 1 - Enter column (0-2): ");
            int col = scanner.nextInt();
            game.makeMove(player1, row, col);
            board.printBoard();

            if (game.isGameOver()) {
                break;
            }

            // Player 2's turn
            System.out.print("Player 2 - Enter row (0-2): ");
            row = scanner.nextInt();
            System.out.print("Player 2 - Enter column (0-2): ");
            col = scanner.nextInt();
            game.makeMove(player2, row, col);
            board.printBoard();
        }
        scanner.close();
    }
}
