package cnn.leetcode.soluction;

public class uniquePathsII_63 {

        public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int n = obstacleGrid.length; // 行数
            int m = obstacleGrid[0].length; // 列数
            int[][] result = new int[n][m];
            int a = ((obstacleGrid[0][0] == 1)?(result[0][0] = 0):(result[0][0] = 1));
            // System.out.print(a);

            int x = 1;
            int y = 1;
            while(x < n){
                if(obstacleGrid[x][0] == 1 ||result[x-1][0] == 0 ){
                    result[x++][0] = 0;
                    continue;
                }
                result[x++][0] = 1;
               // System.out.print(result[x-1][0]);
            }
            while(y < m){
                if(obstacleGrid[0][y] == 1 || result[0][y-1] == 0){
                    result[0][y++] = 0;
                    continue;
                }
                result[0][y++] = 1;
             //   System.out.print(obstacleGrid[0][y-1]);
            }
            for(int i  =1;i<n;i++)
                for(int j =1;j<m;j++){
                    if(obstacleGrid[i][j] == 1){
                        result[i][j] = 0;
                    }else
                        result[i][j] = result[i-1][j] + result[i][j-1];
                }
            return result[n-1][m-1];
        }

}
