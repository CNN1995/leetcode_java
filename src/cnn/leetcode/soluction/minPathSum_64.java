package cnn.leetcode.soluction;

public class minPathSum_64 {
    public static int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] result = new int[n][m];
        result[0][0] = grid[0][0];
        int x =1;
        int y =1;
        while(x<n){
            result[x][0] = grid[x][0] + result[x-1][0];
            x++;
        }
        while(y<m){
            result[0][y] = grid[0][y] +result[0][y-1];
            y++;
        }
        for(int i = 1; i < n;i++)
            for(int j = 1; j < m;j++){
                result[i][j] = Math.min(result[i-1][j], result[i][j-1])+grid[i][j];
            }
        return result[n-1][m-1];
    }
}
