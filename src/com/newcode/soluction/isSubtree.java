package com.newcode.soluction;

import com.leetcode.util.TreeNode;

public class isSubtree {
    /**
     * 如上图所示：首先我们试着在树A中找到值为8(树B的根节点的值)的节点。从树A的根节点开始遍历，我们发现它的根节点就是8。
     * 接着我们就去判断树A的根节点下面的子树是不是含有和树B一样的结构。在树A中，根节点的左子节点的值是8，而树B的根节点的左子节点是9，对应的两个节点不同。
     *
     * 　因此，我们仍需要遍历树A，接着查找值为8的节点。
     * 我们在树的第二层找到了一个值为8的节点，然后进行第二步判断，即判断这个节点下面的子树是否含有和树B一样结构的子树。
     * 于是我们遍历这个节点下面的子树，先后得到两个子节点9和2，这和B树的结构完全相同。此时我们在树A中找到了一个和树B的结构一样的子树，
     * 因此树B是树A的子结构。
     *
     *
     * 判断root2是否是root1的子结构
     * @param root1
     * @param root2
     * @return
     */

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if(root2==null) return false;
        if(root1==null && root2!=null) return false;
        boolean flag = false;
        if(root1.val == root2.val){
            flag =  isSubTree(root1,root2);
        }
        if(!flag){
            flag =  HasSubtree(root1.left,root2)|| HasSubtree(root1.right,root2);
        }
        return flag;
    }
    // 判断root2是否是root1的子结构

    /**
     *     第二步是判断树A中以R为根节点的子树是不是和树B具有相同的结构
     *     同样，我们也可以用递归的思路来考虑：如果节点R的值和树B的根节点不相同，
     *     则以R为根节点的子树和树B肯定不具有相同的结点；如果它们的值相同，
     *     则递归地判断它们各自的左右节点的值是不是相同。递归的终止条件是我们到达了树Ａ或者树B的叶节点，代码如下：
     *
     * @param root1
     * @param root2
     * @return
     */

    public boolean isSubTree(TreeNode root1,TreeNode root2){
        if(root2==null) return true;
        if(root1==null && root2!=null) return false;
        if(root1.val == root2.val){
            return isSubTree(root1.left,root2.left)&& isSubTree(root1.right,root2.right);
        }else return false;
    }
}
