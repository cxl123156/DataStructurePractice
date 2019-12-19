package cxl.study.leetcode;

public class AddTwoNumbers {

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }


    public static void inverseListNode(ListNode node){
        ListNode prevNode = null;
        ListNode current = node;
        ListNode next = null;

        while(current!=null){
            prevNode = current.next;
            current.next = next;
            next = current;
            current = prevNode;
        }
    }

//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        inverseListNode(l1);
//        inverseListNode(l2);
//    }

    public static void main(String[] args) {
    }

}
