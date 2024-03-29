package com.newcode.soluction;

import com.leetcode.util.ListNode;

public class EntryNodeOfLoop {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode slow = pHead;
        ListNode fast = pHead;
        if (pHead == null || pHead.next == null) {
            return null;
        }
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                // 证明有环
                //这里先证明一个定理：碰撞点到连接点的距离=头指针到连接点的距离
                //假设单链表的总长度为L，头结点到环入口的距离为a，环入口到快慢指针相遇的结点距离为x，环的长度为r，慢指针总共走了s步，则快指针走了2s步。另外，快指针要追上慢指针的话快指针至少要在环里面转了一圈多(假设转了n圈加x的距离)，得到以下关系：
                //    s = a + x
                //    2s = a + nr + x
                //    =>a + x = nr
                //    =>a = nr - x
                ListNode pre = fast;
                slow = pHead;
                while(pre!=slow){
                    pre=pre.next;
                    slow=slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}
