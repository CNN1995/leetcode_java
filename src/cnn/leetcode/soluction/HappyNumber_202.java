package cnn.leetcode.soluction;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Example:
 *
 * Input: 19
 * Output: true
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * 2均为平方
 */
public class HappyNumber_202 {
    public static boolean isHappy(int n){
        List<Integer> list = new ArrayList<Integer>();
        if(n ==1 ){
            return true;
        }
        while(n!=1){
            if(n ==2 || n==3 || n ==4)
            {
                return false;
            }
            list.clear();
            while(n!=0){
                int newItem = n % 10;
                list.add(newItem);
                n= n / 10;
            }
            for(Integer item: list){
                n += Math.pow(item, 2);
            }
            if(n == 1) return true;
        }
        return false;
    }

}
