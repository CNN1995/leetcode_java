package com.newcode.soluction;

import com.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// 树的层序遍历
public class PrintFromTopToBottom {
    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        //树的层序遍历
        ArrayList<Integer> result = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null){
            return null;
        }
        ((LinkedList<TreeNode>) queue).push(root);
        while (queue!=null){
            TreeNode nodeValue = ((LinkedList<TreeNode>) queue).pop();
            result.add(nodeValue.val);
            if(root.left!=null){
                ((LinkedList<TreeNode>) queue).push(root.left);
            }
            if(root.right!=null){
                ((LinkedList<TreeNode>) queue).push(root.right);
            }
        }
        return  result;
    }
    public static  void main(String args[]){
        PrintFromTopToBottom(null);
    }
}
