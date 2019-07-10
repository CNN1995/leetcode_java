package com.newcode.soluction;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 约瑟夫环的解法
 */
public class YueSeFu {
    public static int LastRemaining_Solution(int n, int m) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int i = n;
        int yushu = 0;
        /**
         * 思路：
         * 每个环看做一个新的循环。当遍历到环的最后一个节点，
         * 1、计算本次循环一共删除了几个节点，将剩余节点作为下一轮的环；
         * 2、计算本轮的余数，供下一轮计算使用；
         *   每一轮要删除的节点序号为((count * m) - yushu) -1-removeCount；减一是因为环的序号是从0开始的，
         *   减removeCount是因为list.remove()的机制是，后面的数会依次前移。但(count * m) - 1 - yushu计算的是未前移的位置。
         */
        while ( list.size()>1) {
            // m在本轮中的转数
            int count = 1;
            // 本轮循环中已删除的个数
            int removeCount = 0;
            //
            while ((count * m) - 1 - yushu < i) {
                list.remove(((count * m) - yushu) -1-removeCount);
                if(list.size()==1){
                    return list.get(0);
                }
                removeCount++;
                count++;
            }
            yushu = i-((count-1)* m -yushu);
            i = i - (count - 1);
        }
        return -1;
    }



        public int LastRemaining_Solution2(int n, int m) {
            LinkedList<Integer> list = new LinkedList<Integer>();
            for (int i = 0; i < n; i ++) {
                list.add(i);
            }

            int bt = 0;
            //核心
            while (list.size() > 1) {
                bt = (bt + m - 1) % list.size();
                list.remove(bt);
            }

            return list.size() == 1 ? list.get(0) : -1;
        }

    public static void main(String args[]) {
        int n =0;
        int m =0;
        System.out.println(LastRemaining_Solution(n,m));
    }
}
