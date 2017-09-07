package algorithms.sorting;

import java.util.Arrays;

public class RunningTimeOfAlgorithms {

    public static int [] arr = {1, 2, 3, 5, 66, 33, 34, 31, 32};

    public static void main(String[] args) {

        System.out.println("UnSorted :" + Arrays.toString(arr));
        insertionSort(arr);
        System.out.println("Sorted   :" + Arrays.toString(arr));
    }

    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int idx = i - 1;
            while (idx > -1 && temp < arr[idx]){
                swap(idx+1, idx);
                idx--;
            }
        }
    }

    private static void swap(int i1, int i2) {
        int t = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = t;
    }


}
