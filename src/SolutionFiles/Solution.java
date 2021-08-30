package SolutionFiles;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        int[] x = new int[]{4, 7, 1, 8, 2, 5, 3};
        String[] countries = {"Wood apple", "Blackberry", "Date", "Naseberry", "Tamarind", "Fig", "Mulberry", "Apple", "Plum", "Orange", "Custard apple", "Apricot"};

        bb(x);
    }

    public static void bb(int[] arr) {
        //sort the array;
//        quickSort(arr, 0, arr.length - 1);
        mergeSort(arr, 0, arr.length - 1);

        System.out.println(binarySearch(arr, 0, arr.length - 1, 5));
    }

    private static void mergeSort(int[] arr, int lb, int rb) {
        if (lb < rb) {
            int mid = (lb + rb) / 2;
            mergeSort(arr, lb, mid);
            mergeSort(arr, mid + 1, rb);
            combine(arr, lb, mid, rb);
        }
    }

    private static void combine(int[] arr, int lb, int mid, int rb) {
        int[] sorted = new int[arr.length];
        int i = lb; // lb to mid
        int j = mid + 1; // mid+1 to rb
        int k = lb;

        while (i <= mid && j <= rb) {
            if (arr[i] <= arr[j]) {
                sorted[k] = arr[i];
                i++;
            } else {
                sorted[k] = arr[j];
                j++;
            }
            k++;
        }

        if (i > mid) {
            while (j <= rb) {
                sorted[k] = arr[j];
                j++;
                k++;
            }
        } else {
            while (i <= mid) {
                sorted[k] = arr[i];
                i++;
                k++;
            }
        }


        for (k = lb; k <= rb; k++) {
            arr[k] = sorted[k];
        }

    }

    private static void quickSort(int[] arr, int lb, int rb) {
        if (lb < rb) {
            int placed = partition(arr, lb, rb);
            quickSort(arr, lb, placed - 1);
            quickSort(arr, placed + 1, rb);
        }
    }

    private static int partition(int[] arr, int lb, int rb) {

        int pivot = lb;
        int left = lb;
        int right = rb;

        while (left <= right) {

            while (left <= right && arr[left] <= arr[pivot]) {
                left++;
            }
            while (right >= left && arr[right] > arr[pivot]) {
                right--;
            }

            if (left < right) {
                swap(arr, left, right);
            }
        }
        swap(arr, pivot, right);
        return right;
    }

    private static void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

    private static int binarySearch(int[] arr, int left, int right, int num) {

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == num) {
                return mid;
            }

            if (num < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }


}

class Node {
    int info;
    Node left;
    Node right;

    Node() {
    }

    Node(int info, Node left, Node right) {
        this.info = info;
        this.left = left;
        this.right = right;
    }
}
