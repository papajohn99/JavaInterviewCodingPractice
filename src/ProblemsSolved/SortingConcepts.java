package ProblemsSolved;

import java.util.*;

public class SortingConcepts {

    public static void main(String[] args) {
        SortingConcepts st = new SortingConcepts();
        int[] array = new int[]{34, 15, 29, 8, 16};
        st.bubbleSort(array);
        System.out.println(Arrays.toString(array));

        // selection sort.
        for (int i = 0; i < array.length - 1; i++) {
            st.selectionSort(array, i);
        }

    }

    // bubble sort
    public void bubbleSort(int[] array) {
        int j = array.length - 1; // n-1 times swap
        while (j != 0) {
            for (int i = 0; i < array.length; i++) {
                if (i + 1 < array.length && array[i] > array[i + 1]) {
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
            int temp = 0;
            while (j >= 0) {
                // current elem < previous elem
                if (j - 1 >= 0 && array[j] < array[j - 1]) {
                    //swap the elements.
                    temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
                j--;
            }

        }

    }

}
