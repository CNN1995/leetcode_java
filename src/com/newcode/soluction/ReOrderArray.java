package com.newcode.soluction;

public class ReOrderArray {
    public static void reOrderArray(int [] array) {
            //使用选择排序的思想，见到奇数就往前放
            // 用来标志第一个数是奇数还是偶数 true偶数false奇
        if(array.length==0){
            return;
        }
//            boolean flag = array[0]%2==0?true:false;
//            int i =0;
//            if(array[0]%2!=0){
//                i=1;
//            }
//            int poi = i;
        int poi =0;
            for(int j = poi; j<array.length;j++){
                if(array[j]%2!=0){
                    // 记录本次奇数最后停留的位置，下次在这个位置后面插入
                    int temp = array[j];
                    int k = j-1;
                    for(;k>=poi;k--){
                        array[k+1] =  array[k];
                    }
                    array[poi]= temp;
                    poi = poi+1;
                }

            }
        }

    public  static  void main(String args[]){
        int test[] = {1,2,3,4,5,6};
        int test1[] = {2,4,6,1,3,5,7};
        reOrderArray(test1);
        System.out.println();
    }
}
