package cxl.study.orther;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GuessNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String firstLine = sc.nextLine();
        String secondLine = sc.nextLine();
        System.out.println(guessNumber(firstLine,secondLine));
    }


    public static String guessNumber(String firstLine,String secondLine){
        final String splitSpace = " ";
        String[] answer = firstLine.split(splitSpace);
        String[] inputStr = secondLine.split(splitSpace);
        Map<String,Integer> strIndexMap = new HashMap<>();
        for (int i = 0; i < answer.length; i++) {
            strIndexMap.put(answer[i],i);
        }
        int aCount = 0,bCount = 0;
        for (int i = 0; i < inputStr.length; i++) {
            if (inputStr[i].equals(answer[i])) {
                aCount++;
            }else {
                if (strIndexMap.get(inputStr[i]) != null) {
                    bCount++;
                }
            }
        }
        return aCount+"A"+bCount+"B";
    }
}
