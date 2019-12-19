package cxl.study.leetcode;

public class PerfectNumber {

    public static void main(String[] args) {
        getNumber();
    }

    public static void getNumber(){
        for(int i = 1;i<=1000;i++){
            int temp = 0;
            for(int j = 1;j<=i/2;j++){
                if(i%j == 0){
                    temp += j;
                }
            }
            if(temp == i){
                System.out.println(i);
            }
        }
    }

}
