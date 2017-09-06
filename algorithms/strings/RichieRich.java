package algorithms.strings;


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class RichieRich {
    static String richieRich(String str, int n, int k){
        // Complete this function


        char[] arr = str.toCharArray();

        int x1 = 0;
        int x2 = n-1;

        while(x2>x1){
            int num1 = (int)str.charAt(x1) - (int)'0';
            int num2 = (int)str.charAt(x2) - (int)'0';

            if(num1 == num2){
                x1++; x2--;
            }
            else if(num1 > num2){
                arr[x2] = arr[x1];
                x1++; x2--;
                k--;
            }
            else{
                arr[x1] = arr[x2];
                x1++; x2--;
                k--;
            }
        }


        if(k < 0)
            return "-1";
        else if(k == 0)
            return new String(arr);
        else{
            x1 = 0;
            x2 = n-1;
            while(x2 > x1 && k > 0){
                if(str.charAt(x1) == str.charAt(x2)){
                    if(k > 1 && str.charAt(x1) != '9'){
                        arr[x1] = '9';
                        arr[x2] = '9';
                        x1++; x2--;
                        k -= 2;
                    }
                    else{
                        x1++; x2--;
                    }
                }
                else{
                    if(arr[x1] != '9'){
                        arr[x1] = '9';
                        arr[x2] = '9';
                        x1++; x2--;
                        k--;
                    }else{
                        x1++; x2--;
                    }
                }
            }

            if(k > 0){
                if(n%2 != 0){
                    arr[n/2] = '9';
                }
            }
            return new String(arr);
        }
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
