package PlusOne;

import java.util.Vector;

public class PlusOne {
    public static void main(String[] args) {
        Solution sln = new Solution();
        int[] digits = new int[]{9,9,9,1,2};
        int[] result = sln.plusOne(digits);
        if (result == null) {
            return;
        }
        for (int i=0; i<result.length; i++) {
            System.out.print(result[i]);
        }
        System.out.println();
    }
}

class Solution {
    public int[] plusOne(int[] digits) {
        if (digits.length == 0) {
            return null;
        }
        int sum = 0;
        int n = 0;
        String str = "";
        for(int i=digits.length - 1; i>=0; i--) {
            if (i == digits.length - 1) {
                sum = digits[i] + 1;
            } else {
                sum = digits[i] + n;
            }
            str  += sum % 10;
            n = sum / 10;
            sum = 0;
        }
        
        if (n > 0) {
            str += n;
        }
        str = new StringBuffer(str).reverse().toString();
        int[] result = new int[str.length()];
        for (int i=0; i<str.length(); i++) {
            result[i] = str.charAt(i) - '0';
        }
        return result;
    }
}