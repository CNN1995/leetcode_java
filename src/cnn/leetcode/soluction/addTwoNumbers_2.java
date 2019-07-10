package cnn.leetcode.soluction;
import  com.leetcode.util.ListNode;
public class addTwoNumbers_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /**
         * Input: (2 -> 4 -> 1) + (5 -> 6 -> 4)
         * Output: 7 -> 0 -> 8
         * Explanation: 342 + 465 = 807.
         */

        ListNode list1 = l1;
        ListNode list2 = l2;
        ListNode resultHead = new ListNode(0);
        ListNode p = resultHead;
        int ten  = 0;
        while (list1 != null && list2 != null){
            int resultSum = ten + list1.val + list2.val;
            ten = resultSum /10;
            ListNode resultNode =  new ListNode(resultSum % 10);
            p.next = resultNode;
            p = p.next;
            list1 = list1.next;
            list2 = list2.next;
        }
        while(list1 != null){
            int resultSum = ten + list1.val;
            ten = resultSum /10;
            ListNode resultNode =  new ListNode(resultSum % 10);
            p.next = resultNode;
            p = p.next;
            list1 = list1.next;
        }
        while(list2 != null){
            int resultSum = ten + list2.val;
            ten = resultSum /10;
            ListNode resultNode =  new ListNode(resultSum % 10);
            p.next = resultNode;
            p = p.next;
            list2 = list2.next;
        }
        if(ten != 0){
            ListNode resultNode =  new ListNode(ten);
            p.next = resultNode;
            p = p.next;
        }
        return resultHead.next;
    }
}
