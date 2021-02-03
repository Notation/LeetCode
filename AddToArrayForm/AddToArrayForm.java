package AddToArrayForm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddToArrayForm {
    public static void main(String[] args) {
        Solution sln = new Solution();
        int[] digits = new int[]{0};
        List<Integer> result = sln.addToArrayForm(digits, 100001);
        if (result == null) {
            return;
        }
        for (int i=0; i<result.size(); i++) {
            System.out.print(result.get(i));
        }
        System.out.println();
    }
}

class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> result = new ArrayList<Integer>();
        int i = A.length - 1;
        int tmp = K;
        int m = tmp % 10;
        int sum = 0;
        int n = 0;
        while(i >= 0 || tmp != 0) {
            if (i >= 0) {
                sum += A[i];
            }
            sum += n + m;
            //System.out.printf("m %d n %d i %d sum %d tmp %d\n", m, n, i, sum,tmp);
            result.add(0, sum % 10);
            n = sum / 10;
            i--;
            sum = 0;
            tmp /= 10;
            m = tmp % 10;
        }
        if (n > 0) {
            result.add(0,n);
        }
        return result;
    }
}