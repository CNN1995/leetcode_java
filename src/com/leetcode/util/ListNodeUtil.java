package com.leetcode.util;

public class ListNodeUtil {
    /**
     * 将数组转换为链表
     * @param array
     * @return ListNode
     */
    public static ListNode arrayToListNode(int array[]){
        ListNode head = new ListNode(0);
        ListNode p = head;
        for(int i =0; i < array.length; ++i){
            ListNode temp = new ListNode(array[i]);
            temp.next = null;
            p.next=temp;
            p=p.next;
        }
        return head.next;
    }
    public static void printListNode(ListNode list){
        ListNode p = list;
        while(p!=null){
            System.out.print(p.val + "    ");
            p=p.next;
        }
        System.out.println();
    }
}
