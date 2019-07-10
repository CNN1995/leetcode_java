package cnn.leetcode.soluction;

public class medianOfTwoSortedArrays_4 {
    /**
     *
     * 因为两个数组是有序的，分别为每个数组设定一个指针，按照数的大小，交替向前走，思路同将两个有序数组合并为一个有序数组
     * 记录两个指针的总步数和，不能超过两数组长度和的一半
     * 循环终止时，若为奇数，则最新的数的指针指在中位数的前一位上；若为偶数，则最新的数的指针指在两位中位数的第一位上；二者均需找到下一个位置的数。具体代码见60-80行
     * 15-26行对特殊情况进行处理
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public  static double  findMedianSortedArrays(int[] nums1, int[] nums2) {

        int length1 = nums1.length;
        int length2 = nums2.length;
        int lengthSum = length1 + length2;
        boolean flag = false;

        if(lengthSum % 2 == 0){
            flag = true;
        }
        if(lengthSum == 0){
            return  0;
        }
        if(length1 == 0 && length2 < 2){
                return nums2[0];
        }
        if(length2 == 0 && length1 < 2){
            return nums1[0];
        }
        int nums1Index = 0;
        int nums2Index = 0;
        int indexMid = lengthSum / 2;
        double result = 0;
        boolean whileNums1 = false;
        boolean whileNums2 = false;
        while(nums1Index < length1 && nums2Index < length2 && nums1Index + nums2Index < indexMid){
            if(nums1[nums1Index] <= nums2[nums2Index]){
                ++nums1Index;
                whileNums1 = true;
                whileNums2 = false;
            }else{
                ++nums2Index;
                whileNums1 = false;
                whileNums2 = true;

            }
        }
        while (nums1Index < length1 && nums1Index + nums2Index < indexMid){
            ++nums1Index;
            whileNums1 = true;
            whileNums2 = false;
        }
        while (nums2Index < length2 && nums1Index + nums2Index < indexMid){
            ++nums2Index;
            whileNums1 = false;
            whileNums2 = true;
        }
            int indexMidValue = 0;
            if( whileNums1 == true && whileNums2 == false){
                indexMidValue = nums1[--nums1Index];
            }else{
                indexMidValue = nums2[--nums2Index];
            }
            int indexMidValue2 = 0;
            if( whileNums1 == true && whileNums2 == false){
                nums1Index++;
            }else{
                nums2Index++;
            }
            if(nums1Index < length1){
                if(nums2Index < length2){
                    indexMidValue2 = nums1[nums1Index]<nums2[nums2Index]?nums1[nums1Index]:nums2[nums2Index];
                }else {
                    indexMidValue2 = nums1[nums1Index];
                }
            }else {
                indexMidValue2 = nums2[nums2Index];
            }
        if (flag){
            // 偶数
            result = (double)(indexMidValue + indexMidValue2) / 2;
        }else {
            // 奇数
            result = (double)indexMidValue2;
        }
        return result;
    }
    public  static  void  main(String[] args){
        int[] nums1 ={};
        int[] nums2 ={1};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }
}
