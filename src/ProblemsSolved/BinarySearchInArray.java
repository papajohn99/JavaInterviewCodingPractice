package ProblemsSolved;

import java.util.Arrays;

public class BinarySearchInArray {
    public static void main(String[] args) {
        BinarySearchInArray st = new BinarySearchInArray();
        int[] array = new int[]{30, 10, 20, 5, 80, 90, 15, 50, 70};
        int result = st.binarySearch(array, 15);
        System.out.println(result);
    }

    public int binarySearch(int[] arr, int numberTOSearch) {
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;

            if (arr[middle] == numberTOSearch) {
                return middle;
            }

            if (numberTOSearch < arr[middle]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return -1;
    }
}
