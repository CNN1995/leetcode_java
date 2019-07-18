package com.newcode.soluction;

import com.leetcode.util.TreeNode;

public class is_balanceTree {
    /**
     * 判断一棵树是否是平衡二叉树
     * 运行时间：16ms
     * 占用内存：9308k
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        // 平衡二叉树的条件
        //一棵平衡二叉树，左右子树的高度差是+-1，
        //平衡二叉树的左右子树分别也是平衡二叉树
        if(root == null){
            return true;
        }
        int left = height(root.left);
        int right = height(root.right);
        int result = Math.abs(left-right);
        if(result<=1){
            boolean left_IsBalanced = IsBalanced_Solution(root.left);
            boolean right_IsBalanced = IsBalanced_Solution(root.right);
            return left_IsBalanced && right_IsBalanced;
        }else{
            return false;
        }

    }
    public int height(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = 0;
        int right =0;
        if(root.left!=null){
            left = height(root.left);
        }
        if(root.right!=null){
            right = height(root.right);
        }
        int max = left>right?left:right;
        return 1+ max;
    }
}
