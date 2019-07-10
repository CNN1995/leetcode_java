package cnn.leetcode.soluction;

import com.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 通102，107
public class AverageofLevelsinBinaryTree_637 {
    /**
     * Runtime: 3 ms, faster than 67.52% of Java online submissions for Average of Levels in Binary Tree.
     * Memory Usage: 39 MB, less than 100.00% of Java online submissions for Average of Levels in Binary Tree.
     * @param root
     * @return
     */
    public List<Double> levelOrder(TreeNode root) {
        // 二叉树的层次遍历 借助队列实现
        List<Double> result = new ArrayList<Double>();
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
                // 计算均值
                double aversgeItem = getAverage(resultitem);
                result.add(aversgeItem);
                resultitem.clear();
                currentCount = nextCurrent;
                nextCurrent =0;
            }

        }

        return result;
    }
    double getAverage(List<Integer> data){
        if(data.size()==0){
            return 0;
        }
        double sum = 0;
        for(Integer item : data){
            sum+=item;
        }
        return sum/data.size();
    }
}
