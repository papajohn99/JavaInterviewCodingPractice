package ProblemsSolved;

import java.io.IOException;
import java.util.Scanner;

/*

find numbers between range that contains a perticular digit.

for example, 3, bw 1 to 20. the out put is 3,13.

*/
public class RangeOfNumbers {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");

        String res;
        int _digit;
        _digit = Integer.parseInt(in.nextLine().trim());

        int _start;
        _start = Integer.parseInt(in.nextLine().trim());

        int _end;
        _end = Integer.parseInt(in.nextLine().trim());

        res = find_numbers(_digit, _start, _end);
        System.out.println(res);

    }

    /*
     * Complete the function below.
     */

    static String find_numbers(int digit, int start, int end) {
        // Initialize result
        StringBuilder result = new StringBuilder();

        for (int i = start; i <= end; i++) {
            if (String.valueOf(i).contains(String.valueOf(digit))) {
                result.append(String.valueOf(i));
                start++;
                result.append(" ");
            }
        }


        return String.valueOf(result);


    }
}

