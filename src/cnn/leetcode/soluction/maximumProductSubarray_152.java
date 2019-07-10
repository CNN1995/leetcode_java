package cnn.leetcode.soluction;

public class maximumProductSubarray_152 {
    public  static int maxProduct(int[] nums) {
        int max[] = new int[nums.length];
        int min[] = new int[nums.length];
         max[0] = nums[0];
         min[0] = nums[0];
         int result = nums[0];
        for(int i = 1;i < nums.length;i++){
            // 符号相同flag== true就*, 否则就不乘
            int a = max[i-1]*nums[i];
           int b = min[i-1]*nums[i];
           // a b nums[i] 三者比大小
            max[i]= Math.max(Math.max(a,b),nums[i]);
            min[i]= Math.min(Math.min(a,b),nums[i]);
            result =Math.max( Math.max(max[i],min[i]),result);
        }
        return result;
    }
}
