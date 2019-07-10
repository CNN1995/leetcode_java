package cnn.leetcode.soluction;

import com.leetcode.util.ListNode;

import java.util.ArrayList;

public class regularExpressionMatching_10 {
    // 使用动态规划
//    public boolean isMatch(String s, String p) {
//        if(s.length() == 0||p.length() == 0){
//            return false;
//        }
//        for(int i = -1, j = -1; i + 1< s.length() && j + 1< p.length(); ){
//           if(s.charAt(i + 1) == p.charAt(j + 1)){
//               ++i;
//               ++j;
//               continue;
//           }
//           if(){
//
//           }
//
//        }
//        return  false;
//
//    }




    public static  String replaceSpace(StringBuffer str) {
        String string = new String(str);
        System.out.print(string);
        String newstring = string.replace("h", "");
        return newstring;
    }
}
