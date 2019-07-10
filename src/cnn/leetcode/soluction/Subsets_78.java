package cnn.leetcode.soluction;

import java.util.ArrayList;
import java.util.List;

public class Subsets_78 {
    public  static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<List<Integer>> temResult = result;
        List<Integer> list = new ArrayList<Integer>();
        // 设置初始条件
        result.add(list);
        for (int i = 0; i < nums.length; i++) {
            for (List<Integer> resultItem : result) {
                List<Integer> item = new ArrayList<Integer>();
                item = resultItem;
                item.add(nums[i]);
                temResult.add(item);
            }
            System.out.print(result.size());
            int len = result.size();
//            for(int j = 0; j < len; j++){
//                List<Integer> item = result.get(j);
//                item.add(nums[i]);
//                result.add(item);
//            }
            List<Integer> nullList = new ArrayList<Integer>();
            // 设置初始条件
            result.add(nullList);
            //将新数字产生的新的子集加入到result数组中
            for (List<Integer> resultItem : temResult) {
                result.add(resultItem);
            }
            // temResult.clear();
        }

        return result;
    }
}
