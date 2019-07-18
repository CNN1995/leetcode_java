package com.newcode.soluction;

public class GetNumberOfK {
    //运行时间：15ms
    //占用内存：9416k

    /**
     * 统计一个数字在排序数组中出现的次数。
     * @param array
     * @param k
     * @return
     */
    public int GetNumberOfK(int [] array , int k) {
        int count =0;
        for(int i =0; i<array.length;i++){
            if(array[i]==k)count++;
        }
        return count;
    }
}
