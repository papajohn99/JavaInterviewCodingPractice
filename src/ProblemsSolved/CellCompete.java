package ProblemsSolved;

import java.util.Arrays;

public class CellCompete {
    /**
     * A colony of eight houses, represented as cells, are arranged in a straight line. Each day evry cell competes with its adjacent cells (neighbours). An integer value of 1 represents an active cell and value of 0 represents as inactive cell. If both the neighbours are either active or inactive, the cell becomes inactive the next day, otherwise it becomes active on the next day.
     * <p>
     * The two cells on the ends have a single adjacent cell, so the other adjacent cell can be assumed to be always inactive. Even after updating the cell state, its previous state is considered for updating the state of other cells. The cell information of all cells should be updated simultatiously.
     * <p>
     * Write an algorithm to output the state of the cells after the given number of days.
     * <p>
     * Input
     * <p>
     * The input to the function consists of two arguments:
     * <p>
     * states, a list of integers representing the current state of cells.
     * days, an integer representing the number of days.
     * Output
     * <p>
     * Return a list of integers representing the state of the cells after the given number of days.
     * <p>
     * Note:
     * <p>
     * The elements of the list states contains 0s and 1st only.
     * <p>
     * Approach
     */
    public static void main(String[] args) {
        int[] arr1 = {1, 0, 0, 0, 0, 1, 0, 0};
        int[] arr2 = {1, 1, 1, 0, 1, 1, 1, 1};
        int[] result = CellCompete.cellCompete(arr1, 1);
        int[] result2 = CellCompete.cellCompete(arr2, 2);
        System.out.println("the result is: " + Arrays.toString(result));
        System.out.println("the result is: " + Arrays.toString(result2));
    }

    /**
     * Example 1
     * Input  : 1      0       0       0       0       1       0       0
     * Output : 0      1       0       0       1       0       1       0
     * <p>
     * Example 2
     * Input  : 1      1       1       0       1       1       1       1
     * Output : 0      0       0       0       0       1       1       0
     *
     * @param states
     * @param days
     * @return
     */
    static int[] cellCompete(int[] states, int days) {

        //loop based on days.
        for (int i = 0; i < days; i++) {

            int previous = 0;
            int next = 0;

            for (int j = 0; j < states.length; j++) {

                if (j == states.length - 1) {
                    next = 0;
                } else {
                    next = states[j + 1];
                }

                if (previous == next) {
                    previous = states[j];
                    states[j] = 0;
                } else {
                    previous = states[j];
                    states[j] = 1;
                }
            }

        }

        return states;
    }
}
