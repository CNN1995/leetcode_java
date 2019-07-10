package com.leetcode.test;

import cnn.leetcode.soluction.Integer_break_343;
import cnn.leetcode.soluction.triangle_120;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args){
        int[][] obstacleGrid= {{0,0,0},
                {0,1,0},
                {0,0,0}};
        int[][] obstacleGrid1= {{0},{0}};
        int[][] grid= {{1,3,1},
                {1,5,1},
                {4,2,1}};
       // System.out.println(uniquePathsII_63.uniquePathsWithObstacles(obstacleGrid1));
       // System.out.println(minPathSum_64.minPathSum(grid));
        int[] nums = {1,2,3};
       // System.out.println(maximumProductSubarray_152.maxProduct(nums));
        //System.out.println(q.subsets(nums));
      //  System.out.println(HappyNumber_202.isHappy(2));
//        List<Integer> item1 = new ArrayList<Integer>();
//        item1.add(2);
//        List<Integer> item2 = new ArrayList<Integer>();
//        item2.add(3);
//        item2.add(4);
//        List<Integer> item3 = new ArrayList<Integer>();
//        item3.add(6);
//        item3.add(5);
//        item3.add(7);
//        List<Integer> item4 = new ArrayList<Integer>();
//        item4.add(4);
//        item4.add(1);
//        item4.add(8);
//        item4.add(3);
//        List<List<Integer>> list = new ArrayList<List<Integer>>();
//        list.add(item1);
//        list.add(item2);
//        list.add(item3);
//        list.add(item4);
//        System.out.println(triangle_120.minimumTotal(list));

        System.out.println(Integer_break_343.integerBreak(10));
    }
}
