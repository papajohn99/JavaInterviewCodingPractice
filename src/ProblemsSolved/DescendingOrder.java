package ProblemsSolved;

import java.util.Arrays;

public class DescendingOrder {

    public static void main(String[] args) {

        int[] numbers = new int[]{1, 2, 9, 3, -15, -5, 0};
        int[] result = getDescendingOrder(numbers);
        System.out.println(Arrays.toString(result));
    }

    private static int[] getDescendingOrder(int[] numbers) {

        int x = 0;

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] < numbers[j]) {
                    x = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = x;
                } else {
                    numbers[i] = numbers[i];

                }
            }
        }
        return numbers;
    }


}
