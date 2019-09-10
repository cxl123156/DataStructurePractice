package cxl.study.datastructure.linkedlist.leetcode;


public class AbbreviationValid {


    /**
     * 判断缩写是否有效
     * 输入 s = “internationalization"，abbr = "i12iz4n"
     * 返回 true
     * 找到字符串中数字和位置
     *
     * @param word
     * @param abbr
     * @return
     */
    static boolean valid(String word, String abbr) {
        char[] chars = abbr.toCharArray();
        int number = 0;
        String numStr = "";
        int prevesIndex = -1;
        if(chars[0] == '0' || chars[chars.length-1]=='0'){
            return false;
        }
        for (int i = 0; i < chars.length; i++) {
            char tmpChar = abbr.charAt(i);
            if (Character.isDigit(abbr.charAt(i))) {
                if("".equals(numStr) && tmpChar == '0'){
                    return false;
                }
                numStr = numStr + tmpChar + "";
                if(i==chars.length-1){
                    number += Integer.parseInt(numStr);
                }
            } else {
                if(!word.contains(tmpChar+"")){
                    return false;
                }
                //不是空字符串代表已经匹配到数字
                if (!"".equals(numStr)) {
                    int tempNumber = Integer.parseInt(numStr);
                    prevesIndex = tempNumber + prevesIndex + 1;
                    number += tempNumber;
                } else {
                    if (prevesIndex != -1) {
                        prevesIndex = number;
                    } else {
                        prevesIndex = i;
                    }

                }
                number++;
                numStr = "";
            }
        }
        return number == word.length();
    }

    public static void main(String[] args) {
        System.out.println(AbbreviationValid.valid("hi", "2i"));
    }
}
