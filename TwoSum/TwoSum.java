package TwoSum;

public class TwoSum {
    public static void main(String[] args) {
        Solution sln = new Solution();
        int[] nums = {3,2,2,4};
        int target = 4;
        int[] result = sln.twoSum(nums, target);
        for (int i : result) {
            System.out.println(i);
        }
        System.out.println();
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i=0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i,j};
                }
            }
        }
        return result;
    }
}