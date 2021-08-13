package ProblemsSolved;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * -  0 1 2
 * 0 [X X O]
 * 1 [O X O]
 * 2 [O X X]
 * <p>
 * X is winner
 */
public class TicTac2D {

    public static void main(String[] args) {

        TicTacBoard board = new TicTacBoard();
        board.setTicTacArr(new char[][]{{'X', 'X', 'O'}, {'O', 'X', 'O'}, {'O', 'X', 'X'}});

        // Part 1 - print 2D matrix
        int rows = board.getTicTacArr().length;
        int columns = board.getTicTacArr()[0].length;

        int j = 0;

        /**
         * Instead of 2 loops in 2D array, we can do this in one loop. O(n)
         */
        for (int i = 0; i < rows * columns; i++) {

            // Find row and column index
            int row = i / columns;
            int col = i % columns;

            // Print the element at
            // current index
            if (j < 3) {
                System.out.print(board.getTicTacArr()[row][col] + " ");
                j++;
            } else {
                System.out.print("\n");
                System.out.print(board.getTicTacArr()[row][col] + " ");
                j = 1;
            }
        }

        // Part 2 - Find the winner.
        String s = null;
        int combinations = 8;

        List<String> patterns = new ArrayList<>();
        patterns.add("XXX");
        patterns.add("OOO");

        for (int i = 0; i < combinations; i++) {
            if (i == 0) {
                s = String.valueOf(board.getTicTacArr()[0][0]) + String.valueOf(board.getTicTacArr()[0][1]) + String.valueOf(board.getTicTacArr()[0][2]);
            } else if (i == 1) {
                s = String.valueOf(board.getTicTacArr()[1][0] + String.valueOf(board.getTicTacArr()[1][1]) + String.valueOf(board.getTicTacArr()[1][2]));
            } else if (i == 2) {
                s = String.valueOf(board.getTicTacArr()[2][0] + String.valueOf(board.getTicTacArr()[2][1]) + String.valueOf(board.getTicTacArr()[2][2]));
            } else if (i == 3) {
                s = String.valueOf(board.getTicTacArr()[0][0] + String.valueOf(board.getTicTacArr()[1][0]) + String.valueOf(board.getTicTacArr()[2][0]));
            } else if (i == 4) {
                s = String.valueOf(board.getTicTacArr()[0][1] + String.valueOf(board.getTicTacArr()[1][1]) + String.valueOf(board.getTicTacArr()[2][1]));
            } else if (i == 5) {
                s = String.valueOf(board.getTicTacArr()[0][2] + String.valueOf(board.getTicTacArr()[1][2]) + String.valueOf(board.getTicTacArr()[2][2]));
            } else if (i == 6) {
                s = String.valueOf(board.getTicTacArr()[0][0] + String.valueOf(board.getTicTacArr()[1][1]) + String.valueOf(board.getTicTacArr()[2][2]));
            } else if (i == 7) {
                s = String.valueOf(board.getTicTacArr()[0][2] + String.valueOf(board.getTicTacArr()[1][1]) + String.valueOf(board.getTicTacArr()[2][0]));
            }

            if (s.equals("XXX")) {
                s = "X";
                break;
            } else if (s.equals("OOO")) {
                s = "O";
                break;
            }
        }

        System.out.println("\n" + "Winner is " + s);

    }

}

class TicTacBoard {
    private char[][] ticTacArr;

    public char[][] getTicTacArr() {
        return ticTacArr;
    }

    public void setTicTacArr(char[][] ticTacArr) {
        this.ticTacArr = ticTacArr;
    }
}