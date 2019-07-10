package cnn.leetcode.soluction;

public class longestPalindromicSubstring_5 {
    /**
     * 从左向右开始，分别以每个字母为中心点，进行奇数回文串和偶数回文串的判断
     * 记录同一字母进行奇数回文串判断和偶数回文串判断的length，找出大者。
     * 将该字母的较大length与全局maxLength进行比较。
     * 时间复杂度O（n2）空间复杂度O（1）
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        int length = s.length();
        if(length< 2 ) {
            return s;
        }
        int maxStart = 0;
        int maxLen = 0;
        for(int i = 0; i < s.length(); ++i){
            int j = 0;
            int jiLen = 0;
            int ouLen = 0;
            int jiStart = 0;
            int ouStart = 0;
            int len = 0;
            int start = 0;
            int m = 0;
            // 奇数的情况
            while(i - j >= 0 && i + j < s.length() && s.charAt(i - j) == s.charAt( i + j)){
                jiStart = i - j;
                jiLen = 2 * j + 1;
                ++j;
            }
            // 偶数的情况
            while ( i - m >= 0 && i + m + 1 < s.length() && s.charAt(i - m) == s.charAt( i + m + 1)  ){
                ouStart = i - m;
                ouLen = 2 * m + 2;
                ++m;
            }
            len = jiLen>ouLen?jiLen:ouLen;
            start = jiLen>ouLen?jiStart:ouStart;
            maxLen = maxLen>len?maxLen:len;
            maxStart = maxLen>len?maxStart:start;
        }
        return s.substring(maxStart, maxStart + maxLen);
    }
    public static void  main(String[] args){
        System.out.println(longestPalindrome("babad"));
    }
}
