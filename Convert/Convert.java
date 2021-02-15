package Convert;

public class Convert {
    public static void main(String[] args) {
        Solution sln = new Solution();
        final String str = "1";
        final int numRows = 4;
        System.out.println(sln.convert(str, numRows));
    }
}

/*
12345678
1   5   
2 4 6 8
3   7

1     7
2   6 8
3 5
4
*/

class Solution {
    public String convert(String s, int numRows) {
        if (s.length() == 0 || numRows == 1) {
            return s;
        }
        int size = s.length() <= numRows ? s.length():numRows;
        StringBuffer[] arr = new StringBuffer[size];
        boolean down = true;
        int curr =  0;
        for (int i=0; i<s.length(); i++) {
            if (arr[curr] == null) {
                arr[curr] = new StringBuffer();
            }
            arr[curr].append(s.charAt(i));
            if (curr <=0 || curr >= numRows - 1) {
                down = !down;
            }
            if (down) {
                curr--;
            } else {
                curr++;
            }
        }
        StringBuffer result = new StringBuffer();
        for (int i=0; i<arr.length; i++) {
            result.append(arr[i]);
        }
        return result.toString();
    }
}
