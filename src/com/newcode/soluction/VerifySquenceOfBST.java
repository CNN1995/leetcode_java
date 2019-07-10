package com.newcode.soluction;
import java.util.Arrays;

public class VerifySquenceOfBST {
    /***
     * 二叉查找树（Binary Search Tree），（又：二叉搜索树，二叉排序树）它或者是一棵空树，或者是具有下列性质的二叉树：
     * 若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
     * 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
     * 它的左、右子树也分别为二叉排序树。
     * @param sequence
     * @return
     */
    public static boolean verifySquenceOfBST(int [] sequence) {
        if(sequence.length==0){
            return false;
        }
        int root  = sequence[sequence.length-1];
        int i =0;
        boolean result = false;
        int poi =0;

        if(sequence.length==1){
           return true;
        }else{
            while(sequence[i]<root&&i<sequence.length-1){
                ++i;
            }
            poi = i;
            while(i<sequence.length-1){
                if(sequence[i]>root){
                    i++;
                }
                return false;
            }
            if(i==sequence.length-1){
                result = true;
            }
        }

        int[] left = Arrays.copyOfRange(sequence,0,poi);
        int[] right = Arrays.copyOfRange(sequence,poi,sequence.length-1);
        boolean leftResult = true;
        boolean rightResult = true;
        if(left.length!=0)
            leftResult = verifySquenceOfBST(left);
        if(right.length!=0)
            rightResult = verifySquenceOfBST(right);
        return result && leftResult && rightResult;
    }
    public  static void main(String args[]){
        int test2[] = {4,11,7,5};
       int test[] =  {4,8,6,12,16,14,10};
        int test3[] = {};
        System.out.println(test3.length);
       try{
        boolean result = verifySquenceOfBST(test3);
           System.out.println(result);
       }

       catch (Exception e){
           System.out.println(e);
       }

    }

}
