package cnn.leetcode.soluction;

import com.leetcode.util.TreeNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 加入两个计数器，一个记录当前层的数量，一个记录下一层的节点数量
public class BinaryTreeLevelOrderTraversal_102 {
    /**
     * Runtime: 1 ms, faster than 75.61% of Java online submissions for Binary Tree Level Order Traversal.
     * Memory Usage: 35.4 MB, less than 92.76% of Java online submissions for Binary Tree Level Order Traversal.
     * (List<Integer>) ((ArrayList<Integer>) resultitem).clone()
     * @param root
     * @return
     */
    // 通107，637
    public List<List<Integer>> levelOrder(TreeNode root) {
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
                result.add((List<Integer>) ((ArrayList<Integer>) resultitem).clone());
                resultitem.clear();
                currentCount = nextCurrent;
                nextCurrent =0;
            }


        }

        return result;
    }
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        {
            //树的层序遍历
            ArrayList<Integer> result = new ArrayList<Integer>();
            Queue<TreeNode> queue = new LinkedList<>();
            if(root == null){
                return null;
            }
            ((LinkedList<TreeNode>) queue).offer(root);
            while (queue!=null){
                TreeNode nodeValue = ((LinkedList<TreeNode>) queue).poll();
                result.add(nodeValue.val);
                if(root.left!=null){
                    ((LinkedList<TreeNode>) queue).offer(root.left);
                }
                if(root.right!=null){
                    ((LinkedList<TreeNode>) queue).offer(root.right);
                }
            }
            return  result;
        }
    }
    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }
    public static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for(int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }

    public static String int2dListToString(List<List<Integer>> nums) {
        StringBuilder sb = new StringBuilder("[");
        for (List<Integer> list: nums) {
            sb.append(integerArrayListToString(list));
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = "[3,9,20,null,null,15,7]";
      //  while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);

            List<List<Integer>> ret = new BinaryTreeLevelOrderTraversal_102().levelOrder(root);

            String out = int2dListToString(ret);

            System.out.print(out);
     //   }
    }
}
