package ProblemsSolved;

import java.util.*;

public class SortingConcepts {

    public static void main(String[] args) {
        SortingConcepts st = new SortingConcepts();
        int[] array = new int[]{34, 15, 29, 8, 16};
        st.bubbleSort(array);
//        System.out.println(Arrays.toString(array));
        // selection sort.
        for (int i = 0; i < array.length - 1; i++) {
            st.selectionSort(array, i);
        }

        st.mergeSort(new int[]{34, 15, 29, 8, 16}, 0, array.length - 1);

    }

    public void quickSort(int[] arr, int low, int high) {
        int left = low, right = high, pivot = low;

        while (arr[pivot] <= arr[right] && pivot != right) {
            right--;

            if (pivot == right)
                return;

            if (arr[pivot] > arr[right]) {
                swap(arr, pivot, right);
                pivot = right;
            }

        }


        while (arr[left] <= arr[pivot] && pivot != left) {
            left++;

            if (pivot == left)
                return;

            if (arr[left] >= arr[pivot]) {
                swap(arr, pivot, left);
                pivot = left;
            }
        }
    }

    public void swap(int[] arr, int p, int i) {
        int temp = arr[i];
        arr[i] = arr[p];
        arr[p] = temp;
    }


    public void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = left + right / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    public void merge(int[] array, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;
        int[] b = new int[array.length];
        while (i <= mid && j <= right) {
            if (array[i] <= array[j]) {
                b[k] = array[i];
                i++;
            } else {
                b[k] = array[j];
                j++;
            }
            k++;
        }

        if (i > mid) {
            while (j <= right) {
                b[k] = array[j];
                j++;
                k++;
            }
        } else {
            while (i <= mid) {
                b[k] = array[i];
                i++;
                k++;
            }
        }

        array = b;
    }

    // bubble sort
    public void bubbleSort(int[] array) {
        int j = array.length - 1; // n-1 times swap
        while (j >= 0) {
            for (int i = 1; i < array.length; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = temp;
                }
            }
            j--;
        }

    }

    // selection sort
    public void selectionSort(int[] array, int startSearch) {

        Integer minNum = array[startSearch];
        Integer minNumindex = 0;

        for (int i = startSearch; i < array.length - startSearch; i++) {
            if (i + 1 < array.length - startSearch && minNum < array[i + 1]) {
                minNum = array[i];
                minNumindex = i;
            }
        }

        // 8, 15, 29, 34, 16
        if (array[startSearch] != minNum) {
            int temp = array[startSearch];
            array[startSearch] = array[minNumindex]; // swap number to min number place
            array[minNumindex] = temp;

        }

    }

    // Insertion Sort
    public void insertionSort(int[] array) {

        for (int i = 1; i < array.length; i++) {
            int j = i;
            while (j > 0) {
                // current elem < previous elem
                if (array[j] < array[j - 1]) {
                    //swap the elements.
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
                j--;
            }

        }

        /* Recursion way

        if (size <= 1) {
            return;
        }

        insertionSort(arr, size - 1);

        int right = size - 1;

        while (right > 0) {
            if (arr[right - 1] > arr[right]) {
                swapNums(arr, right - 1, right);
            }
            right--;
        }*/

    }

}
