package cnn.leetcode.soluction;

import com.leetcode.util.ListNode;
import com.leetcode.util.ListNodeUtil;

import java.lang.reflect.Member;

public class PartitionList_86 {
    public static ListNode partition(ListNode head, int x) {
        if(head == null ||head.next == null){
            return head;
        }
        ListNode p = head.next;
        ListNode pre = head;
        boolean flag = false;
        // 首先找到第一个小于x的节点作为头节点
        if(head.val<x){
            flag = true;
        }
        while(p != null){
            if(flag == true) break;
            if(p.val < x){
                pre.next = p.next;
                p.next =head;
                head=p;
                break;
            }else{
                pre=p;
                p=p.next;
            }
        }
        if(p == null){
            return head;
        }
        p=head;
        pre= new ListNode(-1);
        ListNode preTarget = pre; //目标插入点的前一个节点
        while(p != null){
            if(p.val < x){
                if(preTarget.val < x){
                    pre = p;
                    preTarget = p;
                    p=p.next;
                    continue;
                }
                pre.next = p.next;
                p.next = preTarget.next;
                preTarget.next = p;
                System.out.print(preTarget.next + "  ");
                preTarget = p;
                p = pre.next;
            }else{
                pre=p;
                p=p.next;
            }

        }
        return head;
    }
    public static ListNode partition2(ListNode head, int x){
        if(head == null ||head.next == null){
            return head;
        }
        // p指向当前待判断节点，pre指向p的前一个节点
        // preTarget 指向待插入点的前一个节点，即指向当前已遍历完的部分的小于x的最后一个节点
        // 特殊情况处理：1.首先找到第个小于X的节点，插入到头节点前面；2.处理联系前连个是都小于X的情；
        ListNode p = head;
        ListNode pre= new ListNode(0);
        ListNode preTarget = pre; //目标插入点的前一个节点
        pre.next=head;
        boolean flag = p.val>=x;  //记录头节点是否比X大，如果小则为true
        while(p != null){
            // 找到第一个比x小的节点
            flag = p.val >=x;
            if(flag){
                pre=p;
                p=p.next;
                continue;
            }

            if(p.val<x){
                // 处理前两个节点连续小于x的样例
                if(preTarget.next == p){
                    pre = p;
                    preTarget = p;
                    p=p.next;
                    continue;
                }
                pre.next = p.next;
                p.next = preTarget.next;
                preTarget.next = p;
                // 处理第一个最小节点插入head前面的样例
                if(p.next == head){
                    head = p;
                }
                preTarget = p;
                p = pre.next;
            }else{
                pre=p;
                p=p.next;
            }

        }
        return head;
    }
    public ListNode partition3(ListNode head, int x) {
        // 遍历链表，将小于x的放在一个链表中，将大于x的放在一个链表中，最后把两个链表连起来
        ListNode dummy1 = new ListNode(0), dummy2 = new ListNode(0);  //dummy heads of the 1st and 2nd queues
        ListNode curr1 = dummy1, curr2 = dummy2;      //current tails of the two queues;
        while (head!=null){
            if (head.val<x) {
                curr1.next = head;
                curr1 = head;
            }else {
                curr2.next = head;
                curr2 = head;
            }
            head = head.next;
        }
        curr2.next = null;          //important! avoid cycle in linked list. otherwise u will get TLE.
        curr1.next = dummy2.next;
        return dummy1.next;
    }

    /**
     * 合并两个有序链表
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode Merge(ListNode list1,ListNode list2) {
        // 返回head.next
        ListNode head =  new ListNode(0);
        ListNode newNode =  head;
        ListNode p =  list1;
        ListNode q =  list2;
        int i = 0;
        while(p!= null || q!=null){
            if((q == null && p!=null) ||(p!=null && p.val<= q.val)){
                ListNode temp =  new ListNode(p.val);
                newNode.next=temp;
                temp.next=null;
                newNode=newNode.next;
                if(i==0){
                    head.next=newNode;
                }
                p=p.next;
                ++i;
                continue;
            }
            if((p == null && q!=null) || (q!=null && p.val> q.val)){
                ListNode temp =  new ListNode(q.val);
                newNode.next=temp;
                temp.next=null;
                newNode=newNode.next;
                if(i==0){
                    head.next=newNode;
                }
                q=q.next;
                ++i;
                continue;
            }
        }
        return head.next;
    }
    public static void main(String args[]){
        int[] array1={1,2};
        int[] array2={3,5,6,7};
        ListNode list1 = ListNodeUtil.arrayToListNode(array1);
        ListNode list2 = ListNodeUtil.arrayToListNode(array2);
        ListNode result =  Merge(list1,list2);
        ListNodeUtil.printListNode(result);
    }
}
