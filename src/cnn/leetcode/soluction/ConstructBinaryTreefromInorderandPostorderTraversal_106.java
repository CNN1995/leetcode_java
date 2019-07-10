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

import java.util.Arrays;

/**
 * Runtime: 15 ms, faster than 10.93% of Java online submissions for Construct Binary Tree from Inorder and Postorder Traversal.
 * Memory Usage: 42.9 MB, less than 9.12% of Java online submissions for Construct Binary Tree from Inorder and Postorder Traversal.
 */
class ConstructBinaryTreefromInorderandPostorderTraversal_106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        {
            TreeNode root = null;
            if(postorder.length==0 && inorder.length==0){
                return root;
            }
            if(postorder.length !=inorder.length){
                return root;
            }
            root = new TreeNode(postorder[postorder.length-1]);
            int poi =0;
            for(int  i =0; i < inorder.length; ++i){
                if(inorder[i] == postorder[postorder.length-1]){
                    // 记录根节点在中序遍历中的位置, 找到了中序遍历中左右子树的节点
                    // 前序遍历的左子树长度与中序遍历长度一致，所以左子树区间为1～poi
                    poi = i;
                    break;
                }
            }

            int[] inoredrLeft = Arrays.copyOfRange(inorder,0, poi);
            int[] inoredrRight = Arrays.copyOfRange(inorder,poi+1, inorder.length);
            int[] postoredrLeft = Arrays.copyOfRange(postorder,0, poi);
            int[] postoredrRight = Arrays.copyOfRange(postorder,poi, postorder.length-1);
            TreeNode left = buildTree(inoredrLeft, postoredrLeft);
            TreeNode right = buildTree(inoredrRight, postoredrRight);
            root.left = left;
            root.right = right;
            return root;
        }
    }
}