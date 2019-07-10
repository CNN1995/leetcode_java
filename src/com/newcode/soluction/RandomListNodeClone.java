package com.newcode.soluction;

import com.leetcode.util.RandomListNode;

public class RandomListNodeClone {
    public RandomListNode Clone(RandomListNode pHead)
    {
        RandomListNode pre = pHead;
        if(pHead==null ){
            return null;
        }
        Math.max(1,2);
        // 在原有链表的基础上复制链表
        while(pre!=null){
            RandomListNode temp = new RandomListNode(pre.label);
            temp.next = pre.next;
            pre.next = temp;
            pre = temp.next;
        }
        // 遍历，完成自由指针的指向
        pre=pHead;
        while(pre!=null){
            if(pre.random!=null){
                pre.next.random = pre.random.next;
            }else{
                pre.next.random = null;
            }

            pre=pre.next.next;
        }
        // 将新节点拆分出来,同时回复原链表
        RandomListNode newHead = pHead.next;
        RandomListNode preNewHead = newHead;
        pre = newHead.next;
        pHead.next = pre;
        while(pre!=null){
            preNewHead.next = pre.next;
            preNewHead=pre.next;
            pre.next = preNewHead.next;
            pre = pre.next;
        }
        return newHead;
    }


}
