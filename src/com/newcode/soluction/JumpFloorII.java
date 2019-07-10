package com.newcode.soluction;

public class JumpFloorII {
    /**
     * 运行时间：22ms
     * 占用内存：9180k
     * @param target
     * @return
     * dp[1] = 1;
     *         dp[2] = 2;
     *         dp[3] = dp[1]+dp[2];
     *          dp[4] = 1+dp[1]+dp[2]+dp[3] = 2*dp[3];
     *          dp[i] = 1+dp[1]+dp[2]+dp[3]+,,,+dp[i-1] = 2*dp[i-1];
     *
     */
    public static int JumpFloorIIInterface(int target) {
        int[] dp = new int[target+1];
        if(target == 0 || target == 1 || target == 2|| target == 3){
            return target;
        }
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = dp[1]+dp[2];
        for(int  i = 4; i<=target; i++){
            dp[i] = 2*dp[i-1];
        }

        return dp[target];
    }

}
