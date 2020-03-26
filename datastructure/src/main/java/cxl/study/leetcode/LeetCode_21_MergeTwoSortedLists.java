package cxl.study.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_21_MergeTwoSortedLists {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode(-1);
        Map<String,Integer> map = new HashMap<>();
        int index = 0;
        while (l1.next != null){
            if (l1.val > l2.val) {
                ListNode listNode = new ListNode(l2.val);
                listNode.next = l1;
                mergeTwoLists(listNode,l2);
            }else {
                l1.next = l2;
            }
        }
        return null;
    }

}
