package ProblemsSolved;

import java.util.*;
import java.util.stream.Collectors;

public class MultiDimentional {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        MultiDimentional solution = new MultiDimentional();


        int m, n, o, c = 0, d = 0, f = 0;
        int[][] res = new int[][]{};

        Scanner in = new Scanner(System.in);

        System.out.println("Enter the number of rows and columns of matrix");
        m = in.nextInt();
        n = in.nextInt();

        if (m == 2 && n == 2) {

            int[][] twoDimentional = new int[m][n];

            System.out.println("Enter the 2*2 elements of first matrix");

            for (c = 0; c < m; c++)
                for (d = 0; d < n; d++)
                    twoDimentional[c][d] = in.nextInt();

            res = solution.solutionTwoByTwo(twoDimentional);
        }

        if (m == 3 && n == 3) {

            int[][] threeDimentional = new int[m][n];
            System.out.println("Enter the 3*3 elements of first matrix");

            for (c = 0; c < m; c++)
                for (d = 0; d < n; d++)
                    threeDimentional[c][d] = in.nextInt();


            res = solution.solutionThreeByThree(threeDimentional);
        }
         /*
        System.out.println("Enter the elements of second matrix");

       for (c = 0 ; c < m ; c++)
            for (d = 0 ; d < n ; d++)
                second[c][d] = in.nextInt();

        for (c = 0; c < m; c++)
            for (d = 0; d < n; d++)
                sum[c][d] = first[c][d] + second[c][d];  //replace '+' with '-' to subtract matrices

        System.out.println("Sum of the matrices:");

        for (c = 0; c < m; c++)
        {
            for (d = 0; d < n; d++)
                System.out.print(sum[c][d]+"\t");

            System.out.println();
        }
*/
        List result = Arrays.stream(res).collect(Collectors.toList());;

        for (int[] x : res) {
            result.add(x);
            System.out.println(res[c][d] + "\t");

        }

        System.out.println(result);

        scanner.close();

    }

    private int[][] solutionThreeByThree(int[][] values) {

        int c, d;
        int[][] matrixA = values;
        int[][] matrixB = new int[values.length][values.length];

        for (c = 0; c < matrixB.length; c++) {
            for (d = 0; d < matrixB.length; d++) {
                if (c == 0 && d == 0) {
                    matrixB[c][d] = matrixA[c][d];
                } else if (c == 0 && d == 1) {
                    matrixB[c][d] = matrixA[0][0] + matrixA[0][1];
                } else if (c == 0 && d == 2) {
                    matrixB[c][d] = matrixA[0][0] + matrixA[0][1] + matrixA[0][2];
                } else if (c == 1 && d == 0) {
                    matrixB[c][d] = matrixA[0][0] + matrixA[1][0];
                } else if (c == 1 && d == 1) {
                    matrixB[c][d] = matrixA[0][0] + matrixA[0][1] + matrixA[1][0] + matrixA[1][1];
                } else if (c == 1 && d == 2) {
                    matrixB[c][d] = matrixA[0][0] + matrixA[0][1] + matrixA[0][2] + matrixA[1][0] + matrixA[1][1] + matrixA[1][2];
                } else if (c == 2 && d == 0) {
                    matrixB[c][d] = matrixA[0][0] + matrixA[1][0] + matrixA[2][0];
                } else if (c == 2 && d == 1) {
                    matrixB[c][d] = matrixA[0][0] + matrixA[0][1] + matrixA[1][0] + matrixA[1][1] + matrixA[2][0] + matrixA[2][1];
                } else if (c == 2 && d == 2) {
                    matrixB[c][d] = matrixA[0][0] + matrixA[0][1] + matrixA[0][2] + matrixA[1][0] + matrixA[1][1] + matrixA[1][2] + matrixA[2][0] + matrixA[2][1] + matrixA[2][2];
                }
                //System.out.println(matrixB[c][d] + "\t");
            }
        }

        return matrixB;
    }

    private int[][] solutionTwoByTwo(int[][] values) {


        int c, d;
        int[][] matrixA = values;
        int[][] matrixB = new int[values.length][values.length];

        for (c = 0; c < matrixB.length; c++) {
            for (d = 0; d < matrixB[c].length; d++) {
                if (c == 0 && d == 0) {
                    matrixB[c][d] = matrixA[c][d];
                } else if (c == 0 && d == 1) {
                    matrixB[c][d] = matrixA[0][0] + matrixA[0][1];
                } else if (c == 1 && d == 0) {
                    matrixB[c][d] = matrixA[0][0] + matrixA[1][0];
                } else if (c == 1 && d == 1) {
                    matrixB[c][d] = matrixA[0][0] + matrixA[0][1] + matrixA[1][0] + matrixA[1][1];
                }
                //System.out.println(matrixB[c][d] + "\t");
            }
        }


        return matrixB;
    }


}
