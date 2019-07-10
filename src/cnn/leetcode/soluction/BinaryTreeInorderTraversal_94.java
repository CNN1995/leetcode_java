package cnn.leetcode.soluction;

import com.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

// accept
public class BinaryTreeInorderTraversal_94 {
    List<Integer> result = new ArrayList<Integer>();
    public List<Integer> inorderTraversal(TreeNode root) {
        // 中序遍历
        if(root == null){
            return result;
        }
        inorderTraversal(root.left);
        result.add(root.val);
        inorderTraversal(root.right);
        return result;
    }

}
// accept

//class Solution {
//    List<Integer> result = new ArrayList<Integer>();
//    public List<Integer> inorderTraversal(TreeNode root) {
//        inorder(root);
//        return result;
//    }
//    void inorder(TreeNode root){
//        // 中序遍历
//        if(root == null){
//            return;
//        }
//        inorder(root.left);
//        result.add(root.val);
//        inorder(root.right);
//    }
//}

/***
 Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Inorder Traversal.
 Memory Usage: 33.7 MB, less than 95.07% of Java online submissions for Binary Tree Inorder Traversal.
 */