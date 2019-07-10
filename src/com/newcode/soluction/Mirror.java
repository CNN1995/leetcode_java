package com.newcode.soluction;

import com.leetcode.util.TreeNode;


public class Mirror {
    /**
     * 将一棵树转换为镜像二叉树
     * 递归
     */
    public void Mirror(TreeNode root) {
        if(root==null || (root.left==null && root.right == null)){
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = right;
        root.right = left;
        Mirror(root.left);
        Mirror(root.right);
    }
    /**
     * 将一棵树转换为镜像二叉树
     * 非递归
     * 层次遍历，交换每个节点的左右子树即可
     */
    public void Mirror2(TreeNode root) {
        if(root==null || (root.left==null && root.right == null)){
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        // TODO 层次遍历
    }
}
