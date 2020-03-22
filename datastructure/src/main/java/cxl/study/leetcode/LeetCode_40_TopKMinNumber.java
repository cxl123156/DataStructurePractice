package cxl.study.leetcode;

import java.util.Arrays;

/**
 * 面试题40. 最小的k个数
 * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 */
public class LeetCode_40_TopKMinNumber {

    /**
     * 暴力解法 先排序再取前k个数
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] result = new int[k];
        System.arraycopy(arr,0,result,0,k);
        return result;
    }

}
