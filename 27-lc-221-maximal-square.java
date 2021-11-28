class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = 0;
        int dp[][] = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]= -1;
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='1')
                    ans = Math.max(ans,helper(matrix,i,j,m,n,dp));
            }
        }
        return ans*ans;
    }
    
    public int helper(char[][] matrix, int r, int c, int m, int n,int[][] dp){
        if(r<0 || c<0 || r>=m || c>=n || matrix[r][c] == '0'){
            return 0;
        }
        if(dp[r][c]!=-1){
            return dp[r][c];
        }
        
        int d = 1 + helper(matrix,r+1,c,m,n,dp);
        int right = 1 + helper(matrix,r,c+1,m,n,dp);
        int dr = 1+ helper(matrix,r+1,c+1,m,n,dp);
        
        return dp[r][c] = Math.min(Math.min(d,right),dr);
    }
    
    
    
}

//TC. : O(mn) - recursive fuction => Total O(m2n2)
//SC : O(mn)
