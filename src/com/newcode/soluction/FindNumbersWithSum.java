package com.newcode.soluction;

import java.util.ArrayList;

public class FindNumbersWithSum {
    public static ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        /**
         * 运行时间：24ms
         * 占用内存：10288k
         */

        ArrayList<ArrayList> list = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        int low = 0;
        int high = array.length-1;
        while(low!=high){
       // while(!(low==high || low >high)){
            if(array[low]+array[high]<sum){
                low++;
            }else if(array[low]+array[high]>sum){
                high--;
            }else{
                ArrayList<Integer> item = new ArrayList<>();
                item.add(array[low]);
                item.add(array[high]);
                item.add(array[high]*array[low]);
                list.add(item);
                low++;
                high--;

            }

        }

        int min = 0;

        for(int i =0; i<list.size();i++){
            if((Integer)list.get(i).get(2) < (Integer) list.get(min).get(2)){
                min =i;
            }
        }
        if(list.size()>0){
            if((Integer)list.get(min).get(0) < (Integer) list.get(min).get(1)){
                result.add((Integer) list.get(min).get(0));
                result.add((Integer) list.get(min).get(1));
            }else{
                result.add((Integer) list.get(min).get(1));
                result.add((Integer) list.get(min).get(0));
            }
        }

        return result;
    }

    public static void  main(String ards[]){
        int[] array = {1,2,4,7,11,16};
        int sum = 10;
        int[] array2 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        int sum2 = 21;
        FindNumbersWithSum(array2, sum2);
    }
}
