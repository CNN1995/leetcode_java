package com.newcode.soluction;

public class MaxContinueSubArraySum {
    /**
     * 求连续最大子数组和，动态规划算法
     * @param array
     * @return
     * 运行时间：123ms
     * 占用内存：12844k
     * 不存在负数的情况
     */
    public static  int MaxSubArraySum1(int[] array){
        int length = array.length;
        if(length == 0){
            return 0;
        }
        int max = array[0];
        int[] dp = new int[length];
        dp[0] = array[0];
        for(int i = 1; i < length; ++i){
            if(dp[i-1]<=0) dp[i] = array[i];
            else dp[i] = dp[i-1] + array[i];
            max = dp[i]>max?dp[i]:max;
        }
        return max;
    }

    /**
     * 贪心算法，数组从位置0开始挨个累加，
     * 如果累加结果currentSum<=0,果断放弃前面的所有数，从当前位置重新开始累加
     * @param array
     * @return
     * 运行时间：111ms
     * 占用内存：12992k
     * 不存在负数的情况
     */
    public static int MaxSubArraySum2(int[] array){
        int length = array.length;
        if(length == 0) {
            return 0;
        }

        int currentSum  = array[0];
        int max = currentSum;
        for(int i = 1; i < length; ++i){
            currentSum = currentSum <= 0?array[i]:currentSum+array[i];
            max = max<currentSum?currentSum:max;
            }
        return  max;
    }

    /**
     * 运行时间：19ms
     * 占用内存：9308k
     * @param array
     * @return
     * 存在全负数的情况，  int[] array4 = {-2,-8,-1,-5,-9}; 返回-1
     */
    public static int FindGreatestSumOfSubArray(int[] array) {

        int n = array.length;
        if(n == 0){
            return 0;
        }
        int currentSum = array[0];
        int max = currentSum;
        boolean flag = false; // 标志是否有出现正数
        flag = array[0]<0?false:true;
        for(int i =1; i < n; i++){
            if(array[i]>=0) flag = true;
            if(flag == false){
                if(array[i] > currentSum)
                    currentSum = array[i];
                if(max < currentSum){
                    max = currentSum;
                }
            }else{

                if(currentSum <= 0) currentSum = array[i];
                else currentSum += array[i];
                if(max<currentSum) max = currentSum;
            }

        }
        return max;
    }



    public static void main(String args[]){
        int[] array = {1,-2,3,10,-4,7,2,-5};
        int[] array2 = {-1,-2,-3,3,2,1};
        int[] array3 = {-1,-2,-3};
        int[] array4 = {-2,-8,-1,-5,-9};
        int[] array5 = {2,8,1,5,9};
        int[] array6 = {1,-2,3,10,-4,7,2,-5};

        int result2 = MaxSubArraySum2(array2);
       // int result  = MaxSubArraySum1(array);
        int result3 = FindGreatestSumOfSubArray(array6);
        System.out.print(result3);

    }
}
