package Multiply;

import java.util.Vector;

public class Multiply {
    public static void main(String[] args) {
        Solution sln = new Solution();
        String num1 = "2";
        String num2 = "12";
        String addStr = sln.addString(num1, num2);
        String multiyplyStr = sln.multiply(num1, num2);
        System.out.printf("add -> %s    m -> %s\n", addStr, multiyplyStr);
    }
}

class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        String result = "";
        int n = 0;
        for (int i=0; i<num1.length(); i++) {
            n = num1.charAt(i)- '0';
            String tmp = num2;
            for (int j=0; j<num1.length() - i - 1; j++) {
                tmp += "0";
            }
            String tmpResult = "";
            for(int j=0; j<n; j++) {
                tmpResult = addString(tmpResult, tmp);
            }
            //System.out.println(tmpResult);
            result = addString(result, tmpResult);
        }
        return result;
    }
    public String addString(String num1, String num2) {
        if (num1.equals("") || num1.equals("0")){
            return num2;
        }
        if (num2.equals("") || num2.equals("0")){
            return num1;
        }
        num1 = new StringBuffer(num1).reverse().toString();
        num2 = new StringBuffer(num2).reverse().toString();
        int n = 0;
        int sum = 0;
        StringBuffer result = new StringBuffer();
        for (int i=0; i< num1.length() || i < num2.length(); i++) {
            if (i < num1.length()) {
                sum += num1.charAt(i) - '0';
            }
            if (i < num2.length()) {
                sum += num2.charAt(i) - '0';
            }
            sum += n;
            result.append((sum % 10));
            n = sum / 10;
            sum = 0;
        }
        if (n > 0) {
            result.append(n);
        }
        return result.reverse().toString();
    }
}