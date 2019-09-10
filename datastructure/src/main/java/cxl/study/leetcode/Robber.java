package cxl.study.leetcode;

public class Robber {


    public int rob(int[] nums) {
        int total1 = 0;
        int total2 = 0;
        if (nums.length == 2) {
            total1 = nums[0];
            total2 = nums[1];
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 0) {
            return 0;
        }

        if (nums.length > 2) {
            total1 = nums[0];
            total2 = nums[1];
            for (int i = 0; i < nums.length-1; i++) {
                if ((i + 2) <= (nums.length - 1)) {
                    total1 = total1 + nums[i+2];
                }
            }
            for (int i = 1; i < nums.length; i++) {
                if ((i + 2) <= (nums.length - 1)) {
                    total2 = total2 + nums[i+2];
                }
            }
        }

        return total1 > total2 ? total1 : total2;
    }

}
