package cxl.study.orther;

import java.util.Scanner;

public class TestInput {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String str = scanner.nextLine();
            String[] strArray = str.split(" ");
            System.out.println(strArray[strArray.length - 1].length());
        }

    }

}
