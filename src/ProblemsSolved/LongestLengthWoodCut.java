package ProblemsSolved;

/*
* Given n pieces of wood with length L[i] (integer array).
* Cut them into small pieces to guarantee you could have equal or more than k pieces with the same length.
*
* What is the longest length you can get from the n pieces of wood? Given L & k, return the maximum length of the small pieces.

Notice: You couldn't cut wood into float length.

If you couldn't get >= k pieces, return 0.

Example
For L=[232, 124, 456], k=7, return 114.
* */

import java.util.Arrays;

public class LongestLengthWoodCut {

    public static void main(String[] args) {
        LongestLengthWoodCut s = new LongestLengthWoodCut();
        int ans = s.woodCut(new int[]{232, 124, 456}, 7);
        System.out.println("The answer is " + ans);
    }

    /**
     * Explaination: given 3 pieces, Cut those pieces in to smaller pieces
     * and from those 3 pieces get atleast 7 pieces in the same length and the largest in the size.
     * To get same length we will have to do division.
     * To find maximum length, the longest wood piece is 456 in given array, other pieces can not be cut in length of 456.
     * so we will start with 456 and do 456/1, 456/2, 456/3. and this length we will devide from each given pieces and sum of
     * those remainders will be atleast 7.
     * so when 456/1=456 it will 232/456=0, 124/456=0, 456/456=1 = total is 0+0+1 <= 7.
     * when 456/2=228 it will 232/228=1, 124/228=0, 456/228=2 = total is 1+0+2 <= 7.
     * so on...
     * when 456/4=114 it will 232/114=2, 124/114=1, 456/114=4 = total is 2+1+4 = 7.
     * so the answer is 114.
     *
     * @param L: Given n pieces of wood with length L[i]
     * @param k: An integer
     *           return: The maximum length of the small pieces.
     */
    public int woodCut(int[] L, int k) {

        int maximumLength = 0;
        int longestWood = Arrays.stream(L).reduce((acc, n) -> acc > n ? acc : n).getAsInt();
        int count = 1;

        while (count <= longestWood) {

            int totalPiecewithSameLengthFound = 0;

            maximumLength = longestWood / count; // 456/2 = 228

            for (int wood : L) {
                totalPiecewithSameLengthFound += wood / maximumLength;
            }

            if (totalPiecewithSameLengthFound >= k) {
                return maximumLength;
            } else {
                count++;
            }
        }


        return maximumLength;
    }

    /*    public int woodCut(int[] L, int k) {
        int max = 0;
        for (int i : L) {
            max = Math.max(max, i);
        }

        int longest = 0;
        int high = max, low = 1;

        while (low <= high) {
            int length = low + (high - low) / 2;
            int cnt = 0;
            for (int n : L) {
                cnt += n / length;
            }

            if (cnt >= k) {
                longest = Math.max(longest, length);
                low = length + 1;
            } else {
                high = length - 1;
            }
        }
        return longest;
    }*/
}
