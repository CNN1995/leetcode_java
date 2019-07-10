package cnn.leetcode.soluction;

import com.leetcode.util.TreeNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Runtime: 15 ms, faster than 11.44% of Java online submissions for Construct Binary Tree from Preorder and Inorder Traversal.
 * Memory Usage: 39.6 MB, less than 15.95% of Java online submissions for Construct Binary Tree from Preorder and Inorder Traversal.
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal_105 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            TreeNode root = null;
            if(preorder.length==0 && inorder.length==0){
                return root;
            }
            if(preorder.length !=inorder.length){
                return root;
            }
            root = new TreeNode(preorder[0]);
            int poi =0;
            for(int  i =0; i < inorder.length; ++i){
                if(inorder[i] == preorder[0]){
                    // 记录根节点在中序遍历中的位置, 找到了中序遍历中左右子树的节点
                    // 前序遍历的左子树长度与中序遍历长度一致，所以左子树区间为1～poi
                    poi = i;
                    break;
                }
            }
            // 由此可知前序遍历的左子树是位置范围时 1～poi，右子树是poi+1～preorder.length-1
            // 其中poi+1需要判断 poi+1<=preorder.length-1
            // 前闭后开区间
            // 0 。。。。。左子树。。。。poi(root)....右子树...inorder.length-1
            // 0(root) 1 。。。。。左子树。。。。poi(左子树结束) poi+1(右子树开始)....右子树...preorder.length-1
            int[] inoredrLeft = Arrays.copyOfRange(inorder,0, poi);
            int[] inoredrRight = Arrays.copyOfRange(inorder,poi+1, inorder.length);
            int[] preoredrLeft = Arrays.copyOfRange(preorder,1, poi+1);
            int[] preoredrRight = Arrays.copyOfRange(preorder,poi+1, preorder.length);
            TreeNode left = buildTree( preoredrLeft, inoredrLeft);
            TreeNode right = buildTree(preoredrRight, inoredrRight);
            root.left = left;
            root.right = right;
            return root;
        }
}
 class MainClass {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static String treeNodeToString(TreeNode root) {
        if (root == null) {
            return "[]";
        }

        String output = "";
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (node == null) {
                output += "null, ";
                continue;
            }

            output += String.valueOf(node.val) + ", ";
            nodeQueue.add(node.left);
            nodeQueue.add(node.right);
        }
        return "[" + output.substring(0, output.length() - 2) + "]";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
    //    while ((line = in.readLine()) != null) {
          //  int[] preorder = stringToIntegerArray(line);
    //        line = in.readLine();
         //   int[] inorder = stringToIntegerArray(line);

        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
            TreeNode ret = new ConstructBinaryTreefromPreorderandInorderTraversal_105().buildTree(preorder, inorder);

            String out = treeNodeToString(ret);

            System.out.print(out);
   //     }
    }
}
