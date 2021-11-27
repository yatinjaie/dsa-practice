class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j] = -1;
            }
        }
        if(obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1){
            return 0;
        }
        return helper(obstacleGrid,m,n,0,0,dp);
    }
    
    public int helper(int[][] obstacleGrid, int m, int n, int r, int c,int[][] dp){
        
        if(r==m-1 && c ==n-1){
            return 1;
        }
        else if(r>m-1 || c >n-1){
            return 0;
        }
        if(dp[r][c]!=-1){
            return dp[r][c];
        }
        if(obstacleGrid[r][c] == 1){
            return 0;
        }
        int right = helper(obstacleGrid,m,n,r,c+1,dp);
        int down = helper(obstacleGrid,m,n,r+1,c,dp);
        
        return dp[r][c]= right + down;
    }
}
