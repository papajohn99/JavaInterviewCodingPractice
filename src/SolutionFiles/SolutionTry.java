package SolutionFiles;


import java.awt.print.Book;
import java.util.*;

public class SolutionTry {

    public static void main(String[] args) {
        SolutionTry st = new SolutionTry();
        int[] array = new int[]{14, 30, 10, 20, 5, 80, 90, 15, 50, 70};
        int[][] tD = new int[][]{{5, 0, 2}, {5, 0}};
        int result = st.binarySearch(array, 15);
        System.out.println(result);
    }

    public int binarySearch(int[] arr, int searchNum) {
        quickSort(arr);
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {

            int middleIndex = (left + right) / 2;

            if (arr[middleIndex] == searchNum) {
                return middleIndex;
            }

            if (searchNum > arr[middleIndex]) {
                left = middleIndex + 1;
            } else {
                right = middleIndex - 1;
            }
        }

        return -1;
    }

    private void quickSort(int[] arr) {

        int x = Arrays.stream(arr).reduce((acc, n) -> acc > n ? acc : n).getAsInt();
        System.out.println(x);
    }


    private int[] bubbleSort(int[] arr) {

        int j = arr.length - 1;
        while (j >= 0) {
            for (int i = 1; i < arr.length; i++) {
                if (arr[i - 1] > arr[i]) {
                    swapNums(arr, i - 1, i);
                }
            }
            j--;
        }

        return arr;
    }

    private void swapNums(int[] arr, int highNumInd, int lowNumInd) {
        int temp = arr[highNumInd];
        arr[highNumInd] = arr[lowNumInd];
        arr[lowNumInd] = temp;
    }


}




