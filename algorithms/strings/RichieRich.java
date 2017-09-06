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

        String[] sArr = s.split("");

        if (isPalindrom(sArr) && k == 0)
            return s;

        int tail = s.length() - 1;
        for (int i = 0; i < n && k > 0; i++, tail--) {

            if (!sArr[i].equals(sArr[tail])) {

                if (k > 1){
                    sArr[i] = "9";
                    sArr[tail] = "9";
                    k -= 2;
                }
                else {
                    int a1 = Integer.parseInt(sArr[i]);
                    int a2 = Integer.parseInt(sArr[tail]);
                    if (a1 > a2)
                        sArr[tail] = sArr[i];
                    else
                        sArr[i] = sArr[tail];

                    k--;
                }
                //System.out.print(Arrays.toString(sArr).replaceAll("\\[|\\]|,|\\s", ""));
            }


            if (isPalindrom(sArr)) {
                if (k == 1 && (n % 2) == 1)
                    sArr[n/2] = "9";

                while (k > 1) {
                    //find min value of the palindromial string to replace it with '9'
                    int min = 9;
                    for (int j = 0; j < n; j++) {
                        int jMin = Integer.parseInt(sArr[j]);
                        if (jMin < min)
                            min = jMin;
                    }

                    for (int m = 0; m < n && k > 1; m++) {
                        if (sArr[m].equals(String.valueOf(min))){
                            sArr[m] = "9";
                            sArr[n - m - 1] = "9";
                            k -= 2;
                        }
                    }
                }


                return Arrays.toString(sArr).replaceAll("\\[|\\]|,|\\s", "");
            }

            if (i == tail && (k % 2) == 1) {
                sArr[i] = "9";
                k--;
                while (k > 0) {
                    int min = 9;
                    for (int j = 0; j < n; j++) {
                        int jMin = Integer.parseInt(sArr[j]);
                        if (jMin < min)
                            min = jMin;
                    }

                    for (int m = 0; m < n; m++) {

                    }
                }

            }

            //23
            if (i > tail) {
                if (k > 1) {
                    sArr[i] = "9";
                    sArr[tail] = "9";
                    k--;
                    k--;
                } else
                    return "-1";
            }

        }
        return "-1";
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
