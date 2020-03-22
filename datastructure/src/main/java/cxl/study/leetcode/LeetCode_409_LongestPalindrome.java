package cxl.study.leetcode;

/**
 * 409. 最长回文串
 * https://leetcode-cn.com/problems/longest-palindrome/
 */
public class LeetCode_409_LongestPalindrome {

    public static int longestPalindrome(String s) {
        int[] charArray = new int[128];
        int result = 0;
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            charArray[aChar]++;
        }
        for (int i : charArray) {
            result += i / 2 * 2;
        }
        if (s.length() > result) {
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccccdd"));
    }

}