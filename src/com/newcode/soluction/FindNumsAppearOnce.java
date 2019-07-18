package com.newcode.soluction;

import java.util.HashMap;
import java.util.Map;

public class FindNumsAppearOnce {
    /**
     * 运行时间：22ms
     * 占用内存：9368k
     * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
     * @param array
     * @param num1
     * @param num2
     */
    public static void solution(int [] array,int num1[] , int num2[]) {
        int count =0;
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i =0; i<array.length;i++){
            if(map.containsKey(array[i])){
                map.put(array[i], 2);
            }else{
                map.put(array[i], 1);
            }
        }

        for(int i =0; i<array.length;i++){

            if(map.get(array[i])==1){
                if(count == 0){
                    num1[0]= array[i];
                    count++;
                }else{
                    num2[0] = array[i]; break;
                }

            }
        }
    }
    public  static  void main(String args[]){
        int[] array = {2,4,3,6,3,2,5,5};
        int num1[] = new int[1];
        int[] num2 = new int[1];
        solution(array,num1,num2);
    }
}
