package cnn.leetcode.soluction;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import com.leetcode.util.TreeNode;
public class SymmetricTree_101 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        boolean result = false;
        if(root.left!=null && root.right!=null){
            result = isSame(root.left, root.right);
        }else if(root.left==null && root.right==null){
            result = true;
        }
        return result;
    }
    // 判读两课树是否一样
    //判断root的左子树的左子树是否与右子树的右子树一致
    // 判断root的左子树的右子树是否与右子树的左子树一致
    public boolean isSame(TreeNode left, TreeNode right){
        if(left==null && right==null){
            return true;
        }
        if(left!=null && right!=null&& (left.val == right.val)){
            boolean resultA = false;
            boolean resultB = false;
            if(left.left!=null && right.right!=null){
                resultA = isSame(left.left, right.right);
            }else{
                if(left.left==null && right.right==null){
                    resultA=true;
                }
            }
            if(left.right!=null && right.left!=null){
                resultB = isSame(left.right, right.left);
            }else{
                if(left.right==null && right.left==null){
                    resultB=true;
                }
            }
            System.out.print("resultA="+ resultA + "   resultB=" + resultB);
            if(resultA && resultB){
                return true;
            }
        }
        return false;
    }

}