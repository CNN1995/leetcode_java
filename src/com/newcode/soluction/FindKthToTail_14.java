package com.newcode.soluction;

import com.leetcode.util.ListNode;

public class FindKthToTail_14 {

   // 使用两个指针，两个指针之间的间隔为k，即可；利用双指针的思想
    public ListNode FindKthToTail(ListNode head,int k) {
        ListNode p  = head;
        ListNode q  = head;
        int i = 0;
        while( p!=null){
            if(i>=k){
                q=q.next;
            }
            p=p.next;
            ++i;
        }
        if(i<k){
            return null;
        }
        return q;
    }
}

