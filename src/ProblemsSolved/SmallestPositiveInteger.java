package ProblemsSolved;
/*
* Write a function:

class Solution { public int solution(int[] A); }

that, given an array A of N integers, returns the smallest positive integer (greater than 0) "that does not occur in A."

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.

Given A = [−1, −3], the function should return 1.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000..1,000,000].

*/


public class SmallestPositiveInteger {

    public static void main(String[] args) {
        SmallestPositiveInteger s = new SmallestPositiveInteger();
        int[] intArray = new int[]{1, 6, 7, 4, 1, 2};
        int ans = s.solution1(intArray);
        System.out.println(ans);
    }

    int counter = 1;
    public int solution1(int[] array) {

        for (int i : array) {
            if (i == counter) {
                counter++;
                return solution1(array);
            }
        }
        return counter;
    }


   /*

   public int solution2(int[] arr) {
        int counter = 0;
        while (contains(arr, ++counter));
        return counter;
    }
    public static boolean contains(int[] arr, int counter) {
        for (int n : arr) {
            if (counter == n) {
                return true;
            }
        }
        return false;
    }

    */

}
