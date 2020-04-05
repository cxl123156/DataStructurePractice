package cxl.study.leetcode;

import java.util.*;

public class LeetCode_433_MinimumGeneticMutation {

    public int minMutation(String start, String end, String[] bank) {

        Set<String> bankSet = new HashSet<>();
        Collections.addAll(bankSet, bank);
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        char[] atcg = {'A','T','C','G'};
        char[] startChars = start.toCharArray();
        int level = 0;
        for (int i = 0; i < startChars.length; i++) {
            char[] levelChanged;
            for (char s : atcg) {
                char[] tempStartChars = new char[startChars.length];
                System.arraycopy(startChars,0,tempStartChars,0,startChars.length);
                tempStartChars[i] = s;
                String changed = new String(tempStartChars);
                if(!visited.contains(changed) && bankSet.contains(changed)){
                    startChars = tempStartChars;
                    i = 0;
                    level++;
                    if(changed.equals(end)){
                        return level;
                    }
                    visited.add(changed);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LeetCode_433_MinimumGeneticMutation minimumGeneticMutation = new LeetCode_433_MinimumGeneticMutation();
        System.out.println(minimumGeneticMutation.minMutation("AACCGGTT", "AACCGCTA", new String[]{"AACCGGTA","AACCGCTA","AAACGGTA"}));
    }


}
