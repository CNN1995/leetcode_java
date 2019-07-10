package cnn.leetcode.soluction;

import com.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalII_107 {
    /**
     * Runtime: 1 ms, faster than 88.52% of Java online submissions for Binary Tree Level Order Traversal II.
     * Memory Usage: 35.3 MB, less than 80.57% of Java online submissions for Binary Tree Level Order Traversal II.
     * @param root
     * @return
     */
    // 通637， 102
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        {
            // 二叉树的层次遍历 借助队列实现
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            List<Integer> resultitem = new ArrayList<Integer>();
            Queue<TreeNode> queue = new LinkedList<>();
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
                resultitem.add(value.val);
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
                    // 与T102的不同之处，将最后的数据结果集倒序，始终将最后遍历到的结果，放在最前面
                    result.add(0,(List<Integer>) ((ArrayList<Integer>) resultitem).clone());
                    resultitem.clear();
                    currentCount = nextCurrent;
                    nextCurrent =0;
                }
            }

            return result;
        }
    }
}
