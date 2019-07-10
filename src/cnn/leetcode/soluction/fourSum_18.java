package cnn.leetcode.soluction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class fourSum_18 {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        if(nums == null || nums.length < 4){
            return null;
        }
        
        return  null;
    }
    public static void main(String[] args){

        int[] nums = {1,0,-1,0,-2,2};
        // 排序后：-2 -1 0 0 1 2
        System.out.println(fourSum(nums, 0));
    }
}
