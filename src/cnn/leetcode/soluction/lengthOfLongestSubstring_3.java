package cnn.leetcode.soluction;

import java.util.HashMap;
import java.util.Map;

public class lengthOfLongestSubstring_3 {
    /**
     *
     * @param s
     * @return
     * 滑动窗口每次向右移动一个单位，移动时将上一次的len与maxLen比较，如果len>maxLen则更新，否则不更新
     * 每次将子串放在一个HashMap中
     * 每次滑动窗口移动时，需要将i 回退到start-1的位置，因为i++是在循环体执行完毕才执行的
     * 每次循环都需要判断i是不是最大了，如果是，则没必要再向后判断了，因为不会再有比这个子串长度更长的了。
     * 时间复杂度O（mn），空间复杂度O（n）
     */
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int start = 0; // 当前滑动窗口的起点
        int len = 0; // 当前滑动窗口的长度
        int maxLen = 0;  // 最大子串长度
        int maxStart = 0; // 最大子串起点
        for(int i = 0; i < s.length(); ++i){
            if(map.containsKey(s.charAt(i))){
                maxStart = len>maxLen?start:maxStart;
                maxLen = len>maxLen?len:maxLen;
                ++start;
                len = 0;
                i = start - 1;
                map.clear();

            }else{
                map.put(s.charAt(i), 1);
                ++len;
            }
            if(i == s.length() - 1) {
                maxLen = len > maxLen ? len : maxLen;
                break;
            }
        }
       // System.out.println(s.substring(maxStart, maxStart + maxLen));
        return maxLen;
    }
    public static void main(String[] args){
        int result = lengthOfLongestSubstring(" ");
        System.out.println(result);
    }
}
