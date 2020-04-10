package cxl.study.leetcode;

import java.util.Arrays;

public class LeetCode_153_FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {

        return findUnSortArrayIndex(nums);

    }

//    private int findUnSortArrayIndex(int[] nums) {
//        int left = 0 , right = nums.length-1;
//
//        if(binarySearch(nums,nums[left]) != -1){
//            for (int i = 0; i < nums.length; i++) {
//                if (binarySearch(nums,nums[i]) == -1) {
//                    return i;
//                }
//            }
//        }else {
//            for (int i = 0; i < nums.length; i++) {
//                if (binarySearch(nums,nums[i]) != -1) {
//                    if(nums[i] > nums[i+1]){
//                        return i+1;
//                    }else {
//                        return i;
//                    }
//                }
//            }
//        }
//
//        return 0;

//    }

    public int binarySearch(int[] array){
        int left=0,right = array.length;
        int mid = 0;
        while (left <= right){
            mid = (left + right) / 2;
            if(array[mid] > array[mid+1]){
                return mid+1;
            }else {
                right = mid - 1;
            }
        }
        return 0;
    }

    public int findUnSortArrayIndex(int[] nums){
        int left=0,right = nums.length - 1;
        int mid = 0;
        while (left < right){
            mid = left + (right-left) /2;
            if(nums[mid] > nums[right]){
                left = mid + 1;
            }else {
                right = mid ;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        LeetCode_153_FindMinimumInRotatedSortedArray sortedArray = new LeetCode_153_FindMinimumInRotatedSortedArray();
        int[] array = {3,4,5,1,2};
        System.out.println(sortedArray.findMin(array));

    }

}
