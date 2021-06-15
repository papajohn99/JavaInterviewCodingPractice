package ProblemsSolved;

import SolutionFiles.SolutionSample;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Find highest common divisor between all the n elements in array.
 */
public class findGCD {
    public static void main(String[] args) {
        int[] arr1 = {2, 4, 6, 8, 10};
        int result = findGCD.getGCD(arr1, 5);
        System.out.println("the result is: " + result);
    }

    static int getGCD(int[] arr, int num) {
        List<Integer> x = Arrays.stream(arr).boxed().collect(Collectors.toList());
        int gcd = 0;
        int max = Arrays.stream(arr).reduce((acc, n) -> acc > n ? acc : n).getAsInt();
        int counter = 1;
        while (counter <= max) {
            int j = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] % counter == 0) {
                    j++;
                }
                if (j == arr.length) {
                    gcd = counter;
                }
            }
            counter++;
        }
        return gcd;
    }
}
