package SolutionFiles;


import ProblemsSolved.LongestLengthWoodCut;

import java.util.*;
import java.util.stream.Collectors;

public class SolutionSample {


    public static void main(String[] args) {
        SolutionSample s = new SolutionSample();
//        int ans = s.maxProfit(new int[]{500, 100, 180, 260, 310, 30, 500, 700, 40, 535, 695, 10}); // 1535
//        int ans = s.maxProfit(new int[]{500, 100, 180, 260, 310, 40, 535, 1000, 30, 500, 700, 10}); // 1535
        int ans2 = s.maxProfit(new int[]{5, 7, 7, 8, 8, 10}, 8); // 7
        System.out.println("The answer is " + ans2);
    }

    /**
     * Buy stock at min number and sell at max number.
     *
     * @param prices
     * @return
     */
    public int[] maxProfit(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                list.add(i);
            }
        }

        int[] arr = new int[2];
        arr[0] = list.stream().reduce((acc, n) -> acc < n ? acc : n).get();
        arr[1] = list.stream().reduce((acc, n) -> acc > n ? acc : n).get();
        return arr;
    }

}

