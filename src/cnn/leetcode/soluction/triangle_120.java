package cnn.leetcode.soluction;

import java.util.Arrays;
import java.util.List;


public class triangle_120 {
    /**
     * 这个题目非常明显的动态规划问题， 当前节点的最小值由前面一层的一个（当为第一个或最后一个点）或两个节点决定，
     * 所以维护一个二维数组，保存到达每个节点的最小路径值，通过递推式求出所有的点的最小路径值，然后返回最后一层的最小值就是目标值了
     * //递推式可以很容易看出
     * //中间点
     * minPath[i][j] = min(minPath[i-1][j-1] + triangle[i][j], minPath[i-1][j] + triangle[i][j]);
     *
 */
    public static int minimumTotal(List<List<Integer>> triangle) {
        int result[][] = new int[triangle.size()][];
        // 设置初始条件
        result[0] = new int[triangle.get(0).size()];
        result[0][0]= triangle.get(0).get(0);
        for(int i = 1; i< triangle.size(); i++) {
            result[i] = new int[triangle.get(i).size()];
            // 对每一行的第一个进行单独处理，因为它的来源只有一个
            result[i][0] = result[i - 1][0] + triangle.get(i).get(0);
            for (int k = 1; k < triangle.get(i).size() -1; k++) {
                // 对
                result[i][k] = Math.min(result[i - 1][k-1], result[i - 1][k]) + triangle.get(i).get(k);
            }
            // 对每一行的最后一个数值进行处理，因为它的数据来源只有一个
            result[i][triangle.get(i).size()-1] = result[i - 1][triangle.get(i).size()-2] + triangle.get(i).get(triangle.get(i).size()-1);
        }

        Arrays.sort(result[triangle.size()-1]);
        // 返回到达最后一层的最小路径值
        return result[triangle.size()-1][0];
    }
}



/***
 *
 * public int minimumTotal(List<List<Integer>> triangle) {
 *         int result[] = new int[triangle.size()];
 *         int poi[] = new int[triangle.size()];
 *         //int poi = -1;
 *         // 设置初始条件
 *         result[0] = triangle.get(0).get(0);
 *         poi[0] = 0;
 *         for(int i = 1; i< triangle.size(); i++){
 *             int A = triangle.get(i).get(poi[i-1]);
 *             int B = triangle.get(i).get(poi[i-1]+1);
 *             result[i] = result[i-1] + Math.min(A,B);
 *             // 标识位，标记取左边的还是右边的，用来更新poi[i]
 *             int flag = 0;
 *             poi[i] = poi[i-1];
 *             if(A>=B)  poi[i] = poi[i-1]+1;
 *         }
 *         return result[triangle.size()-1];
 *     }
 */