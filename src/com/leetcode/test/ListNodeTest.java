package com.leetcode.test;

import cnn.leetcode.soluction.Integer_break_343;
import cnn.leetcode.soluction.PartitionList_86;
import cnn.leetcode.soluction.regularExpressionMatching_10;
import com.leetcode.util.ListNode;

import java.util.ArrayList;

public class ListNodeTest {
    public static void main(String[] args){
        ListNode listNode1 = new ListNode(1);
       // ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(2);
        listNode1.next = listNode3;
        //listNode2.next= listNode3;
        listNode3 = null;
        StringBuffer str = new StringBuffer("hello world");
        regularExpressionMatching_10.replaceSpace(str);
       // System.out.println(PartitionList_86.partition2(listNode1, 2));
    //    System.out.println(printListFromTailToHead(listNode1));
        System.out.println(test());

    }
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(listNode == null){
            return result;
        }
        //使用头插
        ListNode p = listNode.next;
        ListNode head = listNode;
        ListNode q = p;
        while(p!=null){
            q = p.next;
            p.next= head;
            head=p;
            p=q;
        }
        p=head;
        while(p!=null){
            result.add(p.val);
        }
        for(int item:result){
            System.out.print(item);
        }
        return result;
    }
    public static int test() {
        int start =100;
        int bai = start /100;
        int ge = start % 100;
        int shi = start /10%10;
        int sum =0;
        while(start <= 999){
             bai = start /100;
             ge = start % 100;
             shi = start /10%10;
            if((bai+ge+shi)%8==0){
                sum+=1;
            }
            start++;
        }
        return sum;
    }

}
