package cxl.study.leetcode;

/**
 * 509. 斐波那契数
 * https://leetcode-cn.com/problems/fibonacci-number/
 */
public class LeetCode_509_FibonacciNumber {

    public int fib(int n) {
        int[] array = new int[n+1];
        return recursion(0,n,array);
    }

    private int recursion(int start,int n,int[] array){
        if(start == 0){
            return 0;
        }

        if(start == 1){
            return 1;
        }

        if (array[n] > 0){
            return array[n];
        }
        array[n] = fib(start+1)+fib(start+2);
        return array[n];
    }
}
