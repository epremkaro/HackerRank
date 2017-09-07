package algorithms.sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BigSorting {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] unsorted = new String[n];
        for (int i = 0; i < n; i++) {
            unsorted[i] = in.next();
        }

        Arrays.sort(unsorted, (o1, o2) -> {
            if (o1.length() == o2.length())
                return o1.compareTo(o2);
            else
                return o1.length() - o2.length();
        });
        System.out.println(Arrays.toString(unsorted));
    }
}
