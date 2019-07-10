package cnn.leetcode.soluction;

import java.util.Arrays;

public class ThreeSumClosest_16 {
    /**
     * 使用双指针的思想同15题3Sum，18题4Sum
     * The code starts from this formation.
     *
     * ----------------------------------------------------
     * ^  ^                                               ^
     * |  |                                               |
     * |  +- second                                     third
     * +-first
     * if nums[first] + nums[second] + nums[third] is smaller than the target, we know we have to increase the sum. so only choice is moving the second index forward.
     *
     * ----------------------------------------------------
     * ^    ^                                             ^
     * |    |                                             |
     * |    +- second                                   third
     * +-first
     * if the sum is bigger than the target, we know that we need to reduce the sum. so only choice is moving 'third' to backward. of course if the sum equals to target, we can immediately return the sum.
     *
     * ----------------------------------------------------
     * ^    ^                                          ^
     * |    |                                          |
     * |    +- second                                third
     * +-first
     * when second and third cross, the round is done so start next round by moving 'first' and resetting second and third.
     *
     * ----------------------------------------------------
     *   ^    ^                                           ^
     *   |    |                                           |
     *   |    +- second                                 third
     *   +-first
     * while doing this, collect the closest sum of each stage by calculating and comparing delta. Compare abs(target-newSum) and abs(target-closest). At the end of the process the three indexes will eventually be gathered at the end of the array.
     *
     * ----------------------------------------------------
     *                                          ^    ^    ^
     *                                          |    |    `- third
     *                                          |    +- second
     *                                          +-first
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest(int[] nums, int target) {
        if(nums.length < 3) {
            return  0;
        }
        Arrays.sort(nums);
        int left = 1;
        int right = nums.length - 1;
        int closestSum  = nums[0] + nums[left] + nums[right];
        for(int i = 0; i < nums.length - 2; ++i){
            if(i != 0 && nums[i - 1] == nums[i]){
                continue;
            }
            left = i + 1;
            right = nums.length - 1;
            while(left < right){
                // cancle dumplist
                if(left - 1 > i && nums[left] == nums[left - 1]){
                    left++;
                    continue;
                }
                if(right + 1 < nums.length - 1 && nums[right] == nums[right + 1]){
                    right--;
                    continue;
                }
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == target)
                    return target;
                if(Math.abs(sum - target) < Math.abs(closestSum - target)){
                    closestSum = sum;
                }
                if(sum < target){
                    left++;

                }   else {
                    right--;
                }
            }
        }
        return closestSum;
    }
    public static void main(String[] args){
        int[] nums = {-1,2,1,-4};
        System.out.println(threeSumClosest(nums,1));
    }
}
