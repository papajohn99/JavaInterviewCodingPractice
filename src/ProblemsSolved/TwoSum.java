package ProblemsSolved;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {


    public static void main(String[] args) throws ParseException {

        TwoSum solution = new TwoSum();
        int[] x = solution.twoSum(new int[]{3, 5, 8}, 13);

        System.out.println(x);
    }

    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                result[1] = i;
                result[0] = map.get(target - numbers[i]);
                return result;
            }
            map.put(numbers[i], i);
        }
        return result;

    }
}


