package cnn.leetcode.soluction;

public class containerWithMostWater_11 {
    /**
     * 暴力破解 时间复杂度O（n2） 空间复杂度 O（1）
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int maxArea = 0;
        int currentArea = 0;
        for(int i = 0; i < height.length - 1; ++i){
            for(int j = i + 1; j < height.length; ++j){
                currentArea = (j - i) * Math.min(height[i], height[j]);
                maxArea = maxArea > currentArea?maxArea:currentArea;
            }
        }
        return maxArea;
    }

    /**
     * 双指针法 时间复杂度O（n） 空间复杂度 O（1）
     * @param height
     * @return
     */
    public static int maxArea2(int[] height) {
        int maxArea = 0;
        int currentArea = 0;
        int left = 0;
        int right = height.length - 1;
        while(left < right){
            currentArea = (right - left) * Math.min(height[right], height[left]);
            maxArea = maxArea > currentArea?maxArea:currentArea;
            int a  = height[right]>height[left]?(++left):(--right);
        }
        return maxArea;
    }
    public  static void main(String[] args){
        int[] height = {1,8,6,2,5,4,8,3,7};
        int result = maxArea2(height);
        System.out.println(result);
    }
}
