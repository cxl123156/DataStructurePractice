package cxl.study.leetcode;

/**
 * 1160. 拼写单词
 * https://leetcode-cn.com/problems/find-words-that-can-be-formed-by-characters/
 */
public class LeetCode_1160_FindWord {


    public static int countCharacters(String[] words, String chars) {
        int result = 0;
        char[] charArray = chars.toCharArray();
        for (String word : words) {
            char[] wordCharArray = word.toCharArray();
            result += spellWord(wordCharArray, charArray);
        }
        return result;
    }

    private static int spellWord(char[] wordCharArray, char[] charArray) {
        int count = 0;
        int j = 0;

        for (int i = 0; i < wordCharArray.length; i++) {
            if (charArray[i] == wordCharArray[j]) {
                count++;
                i++;
            }
            j++;
            if (count == wordCharArray.length) {
                return wordCharArray.length;
            }
            if (j >= wordCharArray.length) {
                return 0;
            }
        }
        return 0;
    }


}
