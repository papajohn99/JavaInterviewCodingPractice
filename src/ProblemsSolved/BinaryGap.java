package ProblemsSolved;/*
* Write a function:

Binary Gap

given N = 1041 the function should return 5, because N has binary representation 10000010001
and so its longest binary gap is of length 5.
Given N = 32 the function should return 0, because N has binary representation '100000' and thus no binary gaps.

*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryGap {

    public static void main(String[] args) {
        BinaryGap s = new BinaryGap();
        int ans = s.solution(1041 );
        System.out.println("The answer is " + ans);
    }

    public int solution(int value) {
        int counter = 0;

        String x = (Integer.toBinaryString(value));
        System.out.println("The Binary string of " + value + " is " + x);
        List<Integer> integerList = new ArrayList<>();

        for (int c : x.chars().toArray()) {
            //here in char 49 represent 1 and 48 represent 0.
            if (c == 48) {
                counter++;
            } else {
                integerList.add(counter);
                counter = 0;
            }
        }

        return Collections.max(integerList);

    }
}