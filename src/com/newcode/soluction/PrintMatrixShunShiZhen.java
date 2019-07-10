package com.newcode.soluction;

import java.util.ArrayList;

public class PrintMatrixShunShiZhen {
    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int i = 0;
        int j = 0;
        int k = 0;
        boolean right = true;
        boolean down = true;
        boolean left = true;
        boolean up = false;
        while (true) {
            // 右
            right = true;
            if(up==false){
                up = true;
                for (; j < matrix[0].length - k; j++) {
                    result.add(matrix[i][j]);
                    right = false;
                }
                if(right==false){
                    j--;
                    // 下
                    down = true;
                    for (i = i+1; i < matrix.length - k; i++) {
                        result.add(matrix[i][j]);
                        down = false;
                    }
                    if(down==false){
                        i--;
                        // 左
                        left = true;
                        for ( j=j-1;j >= 0 + k && i>=0; j--) {
                            result.add(matrix[i][j]);
                            left=false;
                        }
                        if (left==false){
                            j++;
                            // 上
                            up = true;
                            for (i=i-1; i >= 1 + k &&j>=0; i--) {
                                result.add(matrix[i][j]);
                                up=false;
                            }
                            if (up==false)
                                i++;

                        }

                    }

                }
            }

            j = j + 1;
            //   i=i-1;
            k++;

            if(right){
                break;
            }
        }
        return  result;
    }
    public static void main(String args[]){
        int[][] test = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int [][] test2 = {{1},{2},{3},{4},{5}};
        int[][] test3 = {{1,2},{3,4},{5,6},{7,8},{9,10}};
        int[][] test4 = {{1,2,3,4,5},{6,7,8,9,10}};
        ArrayList<Integer> result = printMatrix(test4);
    }

}
