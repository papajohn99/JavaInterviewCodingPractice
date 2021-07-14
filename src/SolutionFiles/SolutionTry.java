package SolutionFiles;


import java.util.*;

public class SolutionTry {

    public static void main(String[] args) {
        SolutionTry st = new SolutionTry();
        int[] array = new int[]{30, 10, 20, 5, 80, 90, 15, 50, 70};
        st.quickSort(array, 0, array.length - 1);
        int x = st.binarySeach(array, 0, array.length - 1, 22);
        System.out.println(x);
    }

    public int binarySeach(int[] array, int left, int right, int val) {
        Arrays.sort(array);

        while (left <= right) {
            int m = left + right / 2; // 5
            if (array[m] == val)
                return m;

            if (val < array[m]) {
                right = m - 1;
            } else {
                left = m + 1;
            }
        }

        return -1;
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

    private int partition(int[] arr, int left, int right) {
        //find pivot
        int pivot = arr[left];
        for (int i = left + 1; i <= right; i++) {
            if (pivot > arr[i]) {
                swap(arr, left, i);
                left = i;
            }
        }
        return left;
    }

    public void swap(int[] arr, int p, int i) {
        int temp = arr[i];
        arr[i] = arr[p];
        arr[p] = temp;
    }


}




