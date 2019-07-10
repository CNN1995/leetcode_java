package cnn.leetcode.soluction;

import com.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal_103 {
    /**
     * Runtime: 1 ms, faster than 75.79% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
     * Memory Usage: 35.4 MB, less than 80.96% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
     * @param root
     * @return
     /
    /*
     *
     *   3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * return its zigzag level order traversal as:
     *
     * [
     *   [3],
     *   [20,9],
     *   [15,7]
     * ]
     * 实现输出结果Z字形输出
    */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

            // 二叉树的层次遍历 借助队列实现
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            List<Integer> resultitem = new ArrayList<Integer>();
            Queue<TreeNode> queue = new LinkedList<>();
            int level =0;
            if(root == null){
                return result;
            }

            int currentCount = 0;
            int nextCurrent =0;
            // 将头节点入队 且本层节点数量+1
            ((LinkedList<TreeNode>) queue).offer(root);
            currentCount =1;
            while (!queue.isEmpty()){
                // 头节点出队，且当前节点数量--；
                TreeNode value  = ((LinkedList<TreeNode>) queue).poll();
                // 将本层节点入队
                if(level%2==0)
                resultitem.add(value.val);
                else
                    resultitem.add(0,value.val);
                currentCount--;
                // 若本层节点已经遍历完毕，将节点list加入到最后的结果集中。
                if(value.left!=null){
                    ((LinkedList<TreeNode>) queue).offer(value.left);
                    nextCurrent++;
                }
                if(value.right!=null){
                    ((LinkedList<TreeNode>) queue).offer(value.right);
                    nextCurrent++;
                }
                if(currentCount == 0)
                {
                    // 实现深复制， 如果写 result.add（resultitem）在 resultitem.clear()时，result中的值也会被清空
                    result.add((List<Integer>) ((ArrayList<Integer>) resultitem).clone());
                    level ++;
                    resultitem.clear();
                    currentCount = nextCurrent;
                    nextCurrent =0;
                }


            }

            return result;

    }
}
