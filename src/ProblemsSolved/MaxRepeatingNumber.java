package ProblemsSolved;

import SolutionFiles.SolutionSample;

import java.util.HashMap;
import java.util.Map;

public class MaxRepeatingNumber {

    public static void main(String[] args) {
        MaxRepeatingNumber s = new MaxRepeatingNumber();
        int ans2 = s.maxProfit(new int[]{3, 2, 3}); // 7
        System.out.println("The answer is " + ans2);
    }

    /**
     * Buy stock at min number and sell at max number.
     *
     * @param
     * @return
     */
    public int maxProfit(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            if (!map.containsKey(n)) {
                map.put(n, 1);
            } else {
                map.put(n, map.get(n) + 1);
            }
        }


        int max = Integer.MIN_VALUE;
        int maximumDigit = 0;
        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            if (m.getValue() > max) {
                max = m.getValue();
                maximumDigit = m.getKey();
            }
        }

        return maximumDigit;
    }
}
