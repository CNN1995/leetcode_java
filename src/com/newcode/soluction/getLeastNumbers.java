package com.newcode.soluction;


import java.util.ArrayList;

public class getLeastNumbers {
    /**
     * 运行时间：22ms
     * 占用内存：9464k
     * 使用冒泡算法寻找前k个最小的数字，时间复杂度比较高
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {

        ArrayList<Integer> list = new ArrayList<Integer>();
        if(k>input.length){
            return list;
        }

        for(int i =0; i <k && i<input.length; i++){
            for(int j= i+1; j<input.length; j++){
                if(input[j]<input[i]){
                    int temp = input[i];
                    input[i] = input[j];
                    input[j] = temp;
                }
            }
            list.add(input[i]);
        }
        return list;
    }
}
