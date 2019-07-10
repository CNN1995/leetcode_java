package cnn.leetcode.soluction;

public class Integer_break_343 {
    public static  int integerBreak(int n) {

        // 设置初始条件
        int itemMax =0 ;
        int resultMulMax[] = new int[n+1];
        resultMulMax[0] = 0;
        resultMulMax[1] = 1;
        resultMulMax[2] = 1;
        for(int k = 3; k <=n; k++){
            for(int i = k - 1; i>1; i--){
                double a = resultMulMax[i] + Math.pow(k-i, 2);
                itemMax = itemMax>(int)a?itemMax:(int)a;
            }
            resultMulMax[k] = itemMax;
        }
        return resultMulMax[n];
    }
}
