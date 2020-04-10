package cxl.study.leetcode;

/**
 * 70. 爬楼梯
 * https://leetcode-cn.com/problems/climbing-stairs/
 */
public class LeetCode_70_ClimbingStairs {

    public int climbStairs(int n) {
        int[] tempArray = new int[n+1];
        int climbedStairs = 0;
        return recursionMethod(n,climbedStairs,tempArray);
    }

    private int recursionMethod(int n, int climbedStairs,int[] tempArray) {
        // 终止条件
        if(climbedStairs > n){
            return 0;
        }
        if(climbedStairs == n){
            return 1;
        }

        if(tempArray[climbedStairs] > 0){
            return tempArray[climbedStairs];
        }
        int times1 = recursionMethod(n,climbedStairs+1,tempArray);
        int times2 = recursionMethod(n,climbedStairs+2,tempArray);
        tempArray[climbedStairs] = times1+times2;
        return tempArray[climbedStairs];
    }

    public int climbStairs2(int n) {
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        int[] tempArray = new int[n+1];
        int climbedStairs = 0;
        return recursionMethod(n,climbedStairs,tempArray);
    }

    private int doClimb(int n,int climbedStairs,int[] tempArray){
        if(climbedStairs > n){
            return 0;
        }

        if(climbedStairs == n){
            return 1;
        }

        int climbOneResult = doClimb(n,climbedStairs+1,tempArray);
        int climbTwoResult = doClimb(n,climbedStairs+2,tempArray);
        if(tempArray[climbedStairs] > 0){
            return tempArray[climbedStairs];
        }
        tempArray[climbedStairs] = climbOneResult+climbTwoResult;
        return tempArray[climbedStairs];
    }


    public static void main(String[] args) {
        LeetCode_70_ClimbingStairs climbingStairs = new LeetCode_70_ClimbingStairs();
        System.out.println(climbingStairs.climbStairs(4));
    }

}
