package cxl.study.leetcode;

import java.util.Arrays;

/**
 * 945. 使数组唯一的最小增量
 * https://leetcode-cn.com/problems/minimum-increment-to-make-array-unique/
 */
public class LeetCode_945_MinimumIncrementToMakeArrayUnique {

    public int minIncrementForUnique(int[] a) {
        Arrays.sort(a);
        int moveTimes = 0;
        for (int i = 0; i < a.length; i++) {
            if (i > 0 && a[i] <= a[i - 1]) {
                int temp = a[i];
                a[i] = a[i - 1] + 1;
                moveTimes += a[i] - temp;
            }
        }
        return moveTimes;
    }
}
