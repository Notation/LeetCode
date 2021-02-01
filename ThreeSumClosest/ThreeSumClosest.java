package ThreeSumClosest;

import java.util.Arrays;

public class ThreeSumClosest{
    public static void main(String[] args) {
        Solution sln = new Solution();
        //int[] nums = new int[]{0,0,0,0,1};
        //int[] nums = new int[]{-1,1,0,1,2,3};
        //int[] nums = new int[]{1,2,4,8,16,32,64,128};
        int[] nums = new int[]{35,28,94,27,0,1,-89,-20,60,-51,35,67,-94,-78,-67,-60,52,40,-4,99,-26,-26,-77,61,-28,9,66,-40,-2,45,59,-37,59,-90,76,100,20,83,37,-65,20,-95,16,-77,-18,53,93,-88,-33,46,-30,-77,-36,79,34,-3,-84,72,-66,-84,-36,94,-26,11,-23,35,1,36,-70,76,-24,91,-9,-73,43,-92,93,39,99,44,73,7,90,-77,-92,-62,-63,90,-81,80,18,68,-89,95,-22,74,-50,-34,58,-64,61,-30,44,-28,48,13,-45,-75,19,86,40,68,74,-62,44,-12,-18,61,95,53,-63,6,46,-74,82,-39,-52,-45,-41,55,99,22,41,-45,-37,-9,-62,-41,28,5,-40,-99,-83,49,15,75,-36,97,79,-45,-4,-82,-2,6,3,-7,-21,68,81,94,-87,76,64,-32,80,-91,65,-84,-61,-64,68,-73,8,-25,23,51,53,-30,65,92,73,-96,20,70,0,10,-37,90,90,0};
        int target = -9;
        int result = sln.threeSumClosest(nums, target);
        System.out.println(result);
    }
}


class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = -999;
        int gap = -1;
        for (int i=0; i<nums.length; i++){
            int head=i+1, tail = nums.length-1;
            while(head < tail) {
                int n = nums[i] + nums[head] + nums[tail];
                if (n == target) {
                    //System.out.printf("i %d head %d tail %d n %d \n",nums[i], nums[head], nums[tail], n);
                    return n;
                } else {
                    int currentGap = Math.abs(n - target);
                    if (gap == -1 || gap > currentGap) {
                        gap = currentGap;
                        result = n;
                        //System.out.printf("i %d head %d tail %d n %d \n",nums[i], nums[head], nums[tail], n);
                    } else if (gap == 0) {
                        return result;
                        //System.out.printf("--> i %d head %d tail %d n %d\n",nums[i], nums[head], nums[tail], n);
                    }
                    if (n > target) {
                        tail--;
                    } else {
                        head++;
                    }
                }
            }
        }
        return result;
    }
}