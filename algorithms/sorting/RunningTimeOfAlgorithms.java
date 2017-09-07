package algorithms.sorting;

import java.util.*;

public class RunningTimeOfAlgorithms {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] arr = new int[N];
        for (
                int i = 0;
                i < N; i++)
        {
            arr[i] = in.nextInt();
        }
        System.out.println(
        getInsertSortShifts(arr));
    }

    private static int getInsertSortShifts(int[] arr) {
        int shifts = 0;
        for (int i = 1; i < arr.length; i++) {
            int t = arr[i];
            int idx = i - 1;
            while (idx > -1 && t < arr[idx]) {
                swap(arr, idx + 1, idx);
                shifts++;
                idx--;
            }
        }
        return shifts;
    }

    private static void swap(int[] arr, int i1, int i2) {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }


}
