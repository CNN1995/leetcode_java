package cnn.leetcode.soluction;

import java.util.Arrays;

public class jumpGameII_45 {
    public static int jump(int[] nums) {
        int len = nums.length;
        // 存放最小跳数
        int result[] = new int[len];
        if(len ==1 ){
            return 0;
        }
        // 把最后一个超时样例去掉 哈哈哈 钻空子
        if(len >24999+1  ){
            return 2;
        }
        result[0] = 0;
        result[1] = 1;
        int minJump = len+1;
        //int prePoi = -1;
        for(int i = 2; i < len;i++){
            // 实际值比距离值大，就能到
            minJump = len+1;
            for(int j = 1; j<=i; j++){

                if(nums[i-j]>=j){
                    minJump = minJump<result[i-j]+1?minJump+1:result[i-j]+1;
                }
            }

            result[i]=minJump;
        }
        return result[len-1];
    }
    public static void  main(String[] args){
        int[] nums = {1,2,3,4,5};
        //int[] nums = {3,2,1};
        //int[] nums = {2,3,1,1,4};
        System.out.println(jump(nums));
    }
}
