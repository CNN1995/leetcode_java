package cnn.leetcode.soluction;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSum_15 {
    /**
     * Runtime = O(n^2); Space = O(1)
     * 本题利用双指针的思想，将时间复杂度从O(n^3)降低到O(n^2)
     * 首先、将数组进行升序排序
     * 然后、固定其中一个数，另外两个数分别从左边和右边开始遍历，看是否有合适的组合，其中需要注意去重操作。
     * @param nums
     * @return
     * containerWithMostWater_11
     */
    public static  List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>>  result = new ArrayList<>();
        if(nums.length <3){
            return result;
        }
        Arrays.sort(nums);
        int left = 1;
        int right = nums.length - 1;

        for(int i = 0; i < nums.length - 2; ++i){
            // 去除重复元素
            if(i!= 0 && nums[i - 1] == nums[i]){
                continue;
            }
            left = i + 1;
            right = nums.length - 1;
            while( i < left && left < right){
                // 去除left指向的重复元素
                if(nums[left] == nums[left - 1] && left -1 > i){
                    left++;
                    continue;
                }
                // 去除right指向的重复元素
                if( right < nums.length -1 && nums[right] == nums[right + 1]){
                    right--;
                    continue;
                }
                if(nums[i] + nums[left] + nums[right] == 0){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);
                    left++;
                    right--;
                }else if(nums[i] + nums[left] + nums[right] < 0 ){
                            left++;
                    }else if(nums[i] + nums[left] + nums[right] > 0)
                        right--;
            }
        }
        return result;
    }
    public static void main(String[] args){

        int[] nums = {-2,0,0,2,2};
        System.out.println(threeSum(nums));
    }
}
