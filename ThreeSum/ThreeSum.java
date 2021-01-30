package ThreeSum;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {
    public static void main(String[] args) {
        int []nums = new int[]{-4, -1, -1, 0, 1, 2};
        // int []nums = new int[]{-3,-2,-1,0,1,2,3,6};
        //int []nums = new int[]{0,0,0,0,0};
        Solution sln = new Solution();
        List<List<Integer>> result = sln.threeSum(nums);
        if (result == null) {
            System.out.println("result is null");
            return;
        }
        System.out.println("\n");
        for (List<Integer> list : result) {
            for (Integer n : list) {
                System.out.printf("%d ",n);
            }
            System.out.println();
        }
    }
}

// -2, -1, 0, 1, 2
// -3, -2, -1, 0, 1, 2, 3, 6
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i=0; i<nums.length; i++) {
            int head=i+1, tail=nums.length-1;
            while(head < tail) {
                int last = head;
                final int n = nums[head] + nums[tail] + nums[i];
                if (n == 0) {
                    result.add(List.of(nums[i], nums[head], nums[tail]));
                    head++;
                    //跳过已经处理的数据
                    while(head < nums.length && last < nums.length && nums[last] == nums[head]) {
                        head++;
                    }
                } else if (n < 0) {
                    head++;
                } else {
                    tail--;
                }
            }
            //跳过已经处理的数据
            for(int j=i+1; j<nums.length && nums[i] == nums[j]; j++) {
                i = j;
            }
        }
        return result;
    }
}