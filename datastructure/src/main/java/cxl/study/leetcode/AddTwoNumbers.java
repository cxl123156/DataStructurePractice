package cxl.study.leetcode;

public class AddTwoNumbers {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }



    int adder = 0;
    /**
     * 1->2>3
     * 0->3
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 ==null){
            if(adder == 1){
                return new ListNode(adder);
            }
            return null;
        }
        int a, b;
        a = l1 == null ? 0 : l1.val;
        b = l2 == null ? 0 : l2.val;
        int temp = a + b + adder;
        int result = 0;
        if(temp >=10){
            adder = 1;
            result = temp % 10;
        }else {
            adder = 0;
            result = temp;
        }
        ListNode resultListNode = new ListNode(result);
        if(l1 !=null && l2==null){
            l2 = new ListNode(0);
        }
        if(l1 == null && l2!=null){
            l1 = new ListNode(0);
        }
        resultListNode.next = addTwoNumbers(l1.next, l2.next);

        return resultListNode;
    }

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;

        ListNode listNode11 = new ListNode(0);
//        ListNode listNode22 = new ListNode(6);
//        ListNode listNode33 = new ListNode(7);
//        listNode11.next = listNode22;
//        listNode22.next = listNode33;
        System.out.println(addTwoNumbers.addTwoNumbers(listNode1, listNode11));
    }

}
