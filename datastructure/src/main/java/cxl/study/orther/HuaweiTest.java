package cxl.study.orther;


import java.util.Scanner;

public class HuaweiTest {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        String s = in.next();
        System.out.println(HuaweiTest.splitStr(k, s));
    }

    public static String splitStr(int k,String str){
        final String spliter = "-";
        String[] strArray = str.split("-");
        String firstStr = strArray[0];
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(firstStr).append(spliter);
        StringBuilder tempStr = new StringBuilder();
        for (int i = 1; i < strArray.length; i++) {
            char[] chars = strArray[i].toCharArray();
            for (int j = 0; j < chars.length; j++) {
                tempStr.append(chars[j]);
            }
        }
        String upperCaseStr = tempStr.toString().toUpperCase();
        if(k == 0 ){
            stringBuilder.append(upperCaseStr);
            return stringBuilder.toString();
        }
        int temp = 0;
        for (char c : upperCaseStr.toCharArray()) {
            if(temp == k){
                temp = 0;
                stringBuilder.append("-");
            }
            stringBuilder.append(c);
            temp++;
        }
        return stringBuilder.toString();
    }

}
