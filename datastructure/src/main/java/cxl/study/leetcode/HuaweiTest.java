package cxl.study.leetcode;

import java.util.Scanner;

public class HuaweiTest {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int[][] data = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                data[i][j] = in.nextInt();
            }
        }
        System.out.println("total count:"+countIsland(m,n,data));
    }


    public static int countIsland(int m, int n, int[][] data) {
        int totalIsland = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (data[i][j] == 1) {
                    totalIsland++;
                    isIsland(m, n, i, j, data);
                }
            }
        }
        return totalIsland;
    }

    private  static boolean isIsland(int totalRow, int totalColum, int currentRow, int currentColum, int[][] data) {
        boolean right = false;
        boolean left = false;
        boolean top = false;
        boolean bottom = false;
        try {
            right = checkRight(currentRow, currentColum, data);
        }catch(ArrayIndexOutOfBoundsException e){

        }

        try {
            left = checkLeft(currentRow, currentColum, data);
        } catch (ArrayIndexOutOfBoundsException e) {
        }

        try {
            top = checkTop(currentRow, currentColum, data);
        } catch (ArrayIndexOutOfBoundsException e) {
        }


        try {
            bottom = checkBottom(currentRow, currentColum, data);
        } catch (ArrayIndexOutOfBoundsException e)  {

        }
        return right || left || top || bottom;

    }

    private static boolean checkLeft(int currentRow, int currentColum, int[][] data) throws ArrayIndexOutOfBoundsException{
        if(data[currentRow][currentColum - 1] == 1){
            data[currentRow][currentColum] = 0;
            return true;
        }else {
            return false;
        }
    }

    private  static boolean checkRight(int currentRow, int currentColum, int[][] data) throws ArrayIndexOutOfBoundsException{
        if(data[currentRow][currentColum + 1]  == 1){
            data[currentRow][currentColum] = 0;
            return true;
        }else {
            return false;
        }
    }

    private static  boolean checkTop(int currentRow, int currentColum, int[][] data) throws ArrayIndexOutOfBoundsException{
        if(data[currentRow - 1][currentColum] == 1){
            data[currentRow][currentColum] = 0;
            return true;
        }else {
            return false;
        }
    }

    private static boolean checkBottom(int currentRow, int currentColum, int[][] data) throws ArrayIndexOutOfBoundsException{
        if(data[currentRow + 1][currentColum] == 1){
            data[currentRow][currentColum] = 0;
            return true;
        }else {
            return false;
        }
    }

    private String removeVowels(String s){
        String emptyChar = "";
        return s.replaceAll("/[aeiou]+/g",emptyChar);
//        return s.replace("/[aeiou]+/g",emptyChar).replace("e",emptyChar)
//                .replace("i",emptyChar).replace("o",emptyChar).replace("u",emptyChar);
    }

}
