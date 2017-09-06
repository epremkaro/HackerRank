package algorithms.strings;


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class RichieRich {
    static String richieRich(String s, int n, int k) {
        if (s == null) return "-1";
        if (s.length() == 1) return (k > 0) ? "9" : s;

        if (k == 0){
            if (isPalindrom(s))
                return s;
            else
                return "-1";
        }

        if (k >= n){
            StringBuilder res = new StringBuilder();
            for (int max = 0; max < n; max++){
                res.append("9");
            }
            return res.toString();
        }

        String[] sArr = s.split("");
        int tail = s.length() - 1;
        for (int i = 0; i < n && k > 0; i++, tail--) {
            if (!sArr[i].equals(sArr[tail])) {
                if (k > 1){
                    sArr[i] = "9";
                    sArr[tail] = "9";
                    k -= 2;
                }

                if (k == 1){
                    int a1 = Integer.parseInt(sArr[i]);
                    int a2 = Integer.parseInt(sArr[tail]);
                    if (a1 > a2)
                        sArr[tail] = sArr[i];
                    else
                        sArr[i] = sArr[tail];

                    k--;
                }
            }
        }


        while (k > 1) {
            for (int m = 0; m < n && k > 1; m++) {
                int a = Integer.parseInt(sArr[m]);
                if (a < 9){
                    sArr[m] = "9";
                    sArr[n - m - 1] = "9";
                    k -= 2;
                }
            }
        }

        if (k == 1 && (n % 2) == 1)
            sArr[n/2] = "9";


        if (isPalindrom(sArr))
            return Arrays.toString(sArr).replaceAll("\\[|\\]|,|\\s", "");
        else
            return "-1";
    }

    private static boolean isPalindrom(String str) {
        return isPalindrom(str.split(""));
    }

    private static boolean isPalindrom(String[] arr) {
        int tail = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            if (i == tail || i > tail)
                return true;

            if (arr[i].equals(arr[tail])) {
                tail--;
                continue;
            } else
                return false;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        String s = in.next();
        String result = richieRich(s, n, k);
        System.out.println(result);
    }
}
