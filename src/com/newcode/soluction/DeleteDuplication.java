package com.newcode.soluction;

import com.leetcode.util.ListNode;
import com.leetcode.util.ListNodeUtil;

public class DeleteDuplication {
    public  static ListNode deleteDuplication(ListNode pHead)
    {
        ListNode p = pHead;
        ListNode pre = pHead;
        ListNode newHead =new ListNode(0);
        ListNode preNewHead = newHead;
        if(pHead==null || pHead.next==null){
            return pHead;
        }
        p = pHead.next;
        while(p!=null){
            if(p.val != pre.val){
                ListNode tempNode = new ListNode(pre.val);
                preNewHead.next = tempNode;
                pre = p;
                p=p.next;
                preNewHead = preNewHead.next;
            }else{
                while(p!= null && p.val == pre.val){
                    p=p.next;
                }
                if(p==null){
                    return newHead.next;
                }
                pre = p;
                p= p.next;
            }
        }
        ListNode tempNode = new ListNode(pre.val);
        preNewHead.next = tempNode;
        return newHead.next;
    }
    public  static void main(String args[]){
        int[] array1 = {1,2,3,3,4,4,5};
        ListNode list1 = ListNodeUtil.arrayToListNode(array1);
        ListNode result  = deleteDuplication(list1);
        ListNodeUtil.printListNode(result);

    }
}
