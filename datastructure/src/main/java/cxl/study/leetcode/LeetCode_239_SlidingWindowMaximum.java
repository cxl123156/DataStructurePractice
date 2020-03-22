package cxl.study.leetcode;

import java.util.*;

/**
 * 239. 滑动窗口最大值
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 */
public class LeetCode_239_SlidingWindowMaximum {

    /**
     * 通过一个双端队列取出每次滑动窗口内的最大值
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }

        int firstIndex = 0;
        int lastIndex = k;
        int[] result = new int[nums.length - k + 1];
        int i = 0;
        while (i < result.length) {
            int[] tempArray = Arrays.copyOfRange(nums, firstIndex, lastIndex);
            int maxNum = findMax(tempArray);
            result[i] = maxNum;
            firstIndex++;
            lastIndex++;
            i++;
        }
        return result;
    }

    private int findMax(int[] nums) {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        arrayDeque.push(nums[0]);
        for (int num : nums) {
            int max = Math.max(arrayDeque.getLast(), num);
            arrayDeque.removeLast();
            arrayDeque.push(max);
        }
        return arrayDeque.getLast();
    }

    public int[] solution2(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        int firstIndex = 0;
        int[] result = new int[nums.length - k + 1];
        int i = 0;
        int temp;
        int maxNum;
        while (i < result.length) {
            temp = firstIndex;
            maxNum = nums[temp];
            for (int j = 0; j < k; j++) {
                maxNum = Math.max(maxNum, nums[temp]);
                temp++;
            }
            result[i] = maxNum;
            firstIndex++;
            i++;
        }
        return result;
    }

    public static int[] solution3(int[] nums,int k){
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        if(nums.length == 0){
            return new int[0];
        }
        int resultIndex = 0;
        int[] result = new int[nums.length-k+1];
        for (int i = 0; i < nums.length; i++) {
            if(queue.size() >= k){
                queue.remove(nums[i-k]);
            }
            queue.offer(nums[i]);
            if(i >= k-1){
                result[resultIndex] = queue.peek();
                resultIndex++;
            }
        }
        return result;
    }

    public int[] solution4(int[] nums,int k){
        // 建立最大堆
        Queue<Integer> max = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                // TODO Auto-generated method stub
                return i2 - i1;
            }
        });
        int n = nums.length;
        if (n == 0) {
            return nums;
        }
        int[] result = new int[n - k + 1];
        int index = 0;
        for (int i = 0; i < n; i++) {
            //移除第一个元素
            if (max.size() >= k) {
                max.remove(nums[i - k]);
            }
            max.offer(nums[i]);
            //更新 result
            if (i >= k - 1) {
                result[index++] = max.peek();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {1,-1,2};
       int[] result = solution3(a,1);
        for (int i : result) {
            System.out.print(i);
            System.out.print(" ");
        }
    }
}
