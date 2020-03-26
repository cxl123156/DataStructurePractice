package cxl.study.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 876. 链表的中间结点
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 */
public class LeetCode_876_MiddleOfTheLinkedList {


    /**
     * 解法1 利用数组缓存节点
     */
    public ListNode middleNode1(ListNode head) {
        if (head == null) {
            return null;
        }
        List<ListNode> listNodes = new ArrayList<>();
        ListNode tempNode = head;
        while (tempNode != null) {
            listNodes.add(tempNode);
            tempNode = tempNode.next;
        }
        int total = listNodes.size();
        return listNodes.get(total / 2);
    }

    /**
     * 快慢指针
     */
    public ListNode middleNode2(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
