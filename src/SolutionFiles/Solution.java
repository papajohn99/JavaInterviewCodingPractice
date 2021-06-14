package SolutionFiles;

import ProblemsSolved.PlaceTransmittersOnRangeOfHouses;

import java.util.*;
import java.text.ParseException;
import java.util.stream.Collectors;


public class Solution {

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

    public static void main(String args[]) throws Exception {
        Solution s = new Solution();
//        int ans = s.woodCut(new int[]{232, 124, 456}, 7);
        int ans = s.findMaxLen(new int[]{232, 124, 456}, 3, 7);
        System.out.println("The answer is " + ans);
    }

    // Function to check if it is possible
// to cut woods into K pieces of
// length len
    static boolean isValid(int wood[], int N,
                           int len, int K) {

        // Stores count of pieces
        // having length equal to K
        int count = 0;

        // Traverse wood[] array
        for (int i = 0; i < N; i++) {

            // Update count
            count += wood[i] / len;
        }
        return count >= K;
    }

    // Function to find the maximum value of L
    static int findMaxLen(int wood[], int N,
                          int K) {

        // Stores minimum possible of L
        int left = 1;

        // Stores maximum possible value of L
        int right = Arrays.stream(wood).max().getAsInt();

        // Apply binary search over
        // the range [left, right]
        while (left <= right) {

            // Stores mid value of
            // left and right
            int mid = left + (right - left) / 2;

            // If it is possible to cut woods
            // into K pieces having length
            // of each piece equal to mid
            if (isValid(wood, N, mid, K)) {

                // Update left
                left = mid + 1;
            } else {

                // Update right
                right = mid - 1;
            }
        }
        return right;
    }

    /*public int woodCut(int[] woods, int totalPieces) {

        int[] result = new int[woods.length];

        for (int i = 0; i < woods.length; i++) {

            int numberOfPieces = 1;
            int lengthOfOriginalPiece = woods[i];

            while (numberOfPieces > 0) {

                int lengthOfEachPiece = lengthOfOriginalPiece / numberOfPieces;

                if (lengthOfEachPiece * numberOfPieces == lengthOfOriginalPiece
                        && numberOfPieces >= totalPieces) {
                    System.out.println("pieces: " + numberOfPieces + " AND " + "length of Wood found: " + lengthOfEachPiece);
                    result[i] = lengthOfEachPiece;
                    break;
                }
                numberOfPieces++;
            }
        }

        int maxLength = 0;
        if (result.length > 0) {
            maxLength = Arrays.stream(result).max().getAsInt();
        }
        return maxLength;
    }
*/
}
