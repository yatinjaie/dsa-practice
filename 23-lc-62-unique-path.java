class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j] = -1;
            }
        }
        return helper(m,n,0,0,dp);
    }
    
    public int helper(int m, int n, int r, int c,int[][] dp){
        
        if(r==m-1 && c ==n-1){
            return 1;
        }
        else if(r>m-1 || c >n-1){
            return 0;
        }
        if(dp[r][c]!=-1){
            return dp[r][c];
        }
        
        int right = helper(m,n,r,c+1,dp);
        int down = helper(m,n,r+1,c,dp);
        
        return dp[r][c]= right + down;
    }
}

//TC : O(mn)
//SC : O(mn)
