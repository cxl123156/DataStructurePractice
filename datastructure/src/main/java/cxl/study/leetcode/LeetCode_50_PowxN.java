package cxl.study.leetcode;

/**
 * 50. Pow(x, n)
 * https://leetcode-cn.com/problems/powx-n/
 */
public class LeetCode_50_PowxN {


    public double myPow(double x, int n) {

        int temp = n < 0 ? -n : n;

        if(n<0){
            x = 1D / x;
        }

        return doPow(x, temp);

    }


    public double doPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        double result = doPow(x,n/2);

        if(n % 2 == 0){
            result = result * result;
        }else {
            result = result * result * x;
        }

        return result;
    }

    public static void main(String[] args) {
        LeetCode_50_PowxN powxN = new LeetCode_50_PowxN();
        System.out.println(powxN.myPow(2, 3));
    }

}
