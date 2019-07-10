package com.newcode.soluction;

import com.leetcode.util.ListNode;
import com.leetcode.util.ListNodeUtil;

import java.util.HashMap;

public class publicNode {
    /**
     * 首先找出两个节点的长度，
     * 计算两个节点长度的差值n
     * 长链先走n步
     * 两个链共同前进，直到找到公共节点。或者两个链都到头了，还没公共节点
     *Runtime: 1 ms, faster than 97.21% of Java online submissions for Intersection of Two Linked Lists.
     * Memory Usage: 38.4 MB, less than 53.61% of Java online submissions for Intersection of Two Linked Lists.
     * @param pHead1
     * @param pHead2
     * @return
     */
    public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        int count1 =0;
        int count2 =0;
        while(p1!=null){
            count1++;
            p1=p1.next;
        }
        while(p2!=null){
            count2++;
            p2=p2.next;
        }
        p1=pHead1;
        p2=pHead2;
        int juli = count1-count2;
        if(juli>0){
            int i =0;
            while(i<juli){
                p1=p1.next;
                i++;
            }
        }
        else{
            int i =0;
            while(i<Math.abs(juli)){
                p2=p2.next;
                i++;
            }
        }
        while(p1!=null && p2!=null){
            if(p1==p2)
                return p1;
            p1=p1.next;
            p2=p2.next;
        }
        return null;
    }
/**
 * 参考解法
 * Runtime: 353 ms, faster than 5.01% of Java online submissions for Intersection of Two Linked Lists.
 * Memory Usage: 47.9 MB, less than 5.00% of Java online submissions for Intersection of Two Linked Lists.
 * ListNode* FindFirstCommonNode2( ListNode *pHead1, ListNode *pHead2) {
 *             ListNode *p1 = pHead1;
 *             ListNode *p2 = pHead2;
 *             while(p1!=p2){
 *                 p1 = (p1==NULL ? pHead2 : p1->next);
 *                 p2 = (p2==NULL ? pHead1 : p2->next);
 *             }
 *             return p1;
 *         }
 *     };
 *
 */

    /**
     *Runtime: 7 ms, faster than 21.65% of Java online submissions for Intersection of Two Linked Lists.
     * Memory Usage: 38.7 MB, less than 48.99% of Java online submissions for Intersection of Two Linked Lists.
     * 利用hashmap的特性
     * @param headA
     * @param headB
     * @return
     */
    public ListNode FindFirstCommonNode3(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        HashMap<ListNode, Integer> hash = new HashMap<ListNode, Integer>();
        while(p1!=null){
            hash.put(p1, null);
            p1=p1.next;
        }
        while (p2!=null){
           if(hash.containsKey(p2)){
               return p2;
           }

            p2=p2.next;
        }
        return null;
    }
    public static  void main(String args[]){
        int array1[]={1,2,3,4,5,6};
        int array2[]={7,3,4,5,6};
        ListNode list1 = ListNodeUtil.arrayToListNode(array1);
        ListNode list2 = ListNodeUtil.arrayToListNode(array2);
        ListNode result = FindFirstCommonNode(list1,list2);
        ListNodeUtil.printListNode(result);
    }
}
