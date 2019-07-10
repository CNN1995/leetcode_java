package com.newcode.soluction;

public class minNumberInRotateArray_6 {
   // 链接：https://www.nowcoder.com/questionTerminal/9f3231a991af4f55b95579b44b7a01ba?toCommentId=3101888
    //定义一个头指针一个尾指针，相向而行，分别比较array[start]和array[end].
    //如果array[start]>=array[end]    则start++;否则end--;
    public int minNumberInRotateArray(int [] array) {
        if(array.length==0){
            return 0;
        }
        int start = 0;
        int end = array.length-1;
        while(start!=end){
            if(array[start]>=array[end]){
                start++;
            }
            else end--;
        }
        return array[start];
    }
}
