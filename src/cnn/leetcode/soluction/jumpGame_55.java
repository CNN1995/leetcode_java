package cnn.leetcode.soluction;

import java.util.Arrays;

/**
 * 从后向前推，每次都找距离最近的那个能到达的那个点，再以这个点为终点进行计算
 * 边缘条件：直到最后一个子数组里面只有一个数的时候，返回true；
 * nums = {2,3,1,1,4} 求 2 3 1 1 能不能到4的位置
 * 2 3 1 1 4 其中"1"走一步可以到4。转化为子问题2 3 1 能不能到1的位置；
 * 然后转化为2 3 能不能到1 的位置
 * 然后转化为2 能不能到3的位置
 * 然后转化为能不能到2 的位置，2一定能到于是，true
 *
 * 若以上任何一步结结构为false 则整体为false；
 */
public class jumpGame_55 {
    // 非递归
    public static boolean canJump(int[] nums) {
        int  n = nums.length;
        if(n == 1){
            return true;
        }
        while(n > 0){
            // 每次切分一个子数组
            int[] result = Arrays.copyOfRange(nums,0,n-1);
            int  i = n-2;
            for(;i >= 0; i--){
                if(result[i] >= n-1-i){
                    n= i+1;
                    if(n == 1 && result[0] !=0){
                        return true;
                    }
                    break;
                }
            }
            if(i == -1){
                return false;
            }
        }
        if(n ==1){
            return true;
        }
        return false;
    }
    // 递归
        public static boolean canJump2(int[] nums) {
        int  n = nums.length;
        if(n ==1){
            return true;
        }
        if(n == 0)
            return false;
        int i = n-2;
        boolean flag = false;
        for(;i >= 0; i--){
            if(nums[i] >= n-i-1) {
                flag = true;
                n = i + 1;
                break;
            }
        }
        if(flag == false)
        n = i+1;
        return canJump(Arrays.copyOfRange(nums,0,n));
    }


    public static void  main(String[] args){
        //int[] nums = {0};
        //int[] nums = {3,2,1,0,4};
        int[] nums = {2,3,1,1,4};
        int[] result = Arrays.copyOfRange(nums,0,3-1);
      //  int[] nums = {8,2,4,4,4,9,5,2,5,8,8,0,8,6,9,1,1,6,3,5,1,2,6,6,0,4,8,6,0,3,2,8,7,6,5,1,7,0,3,4,8,3,5,9,0,4,0,1,0,5,9,2,0,7,0,2,1,0,8,2,5,1,2,3,9,7,4,7,0,0,1,8,5,6,7,5,1,9,9,3,5,0,7,5};
        System.out.println(canJump(nums));
    }
}
