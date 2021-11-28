class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int ans = Integer.MAX_VALUE;
        int m = matrix.length;
        int n = matrix[0].length;
        int dp[][] = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                dp[i][j]= -1;
            }
        }
        for(int i=0;i<matrix[0].length;i++){
            ans = Math.min(ans,helper(matrix,0,i,dp));
        }
        return ans;
    }
    
    static int helper(int[][] matrix ,  int r, int c,int dp[][]){
        int m = matrix.length;
        int n = matrix[0].length;
        if(r<0 || c <0 || r>=m || c>= n){
            return 10000000;
        }
        if(dp[r][c]!=-1){
            return dp[r][c];
        }
        if(r==m-1){
            return matrix[r][c];
        }
        
        int d = matrix[r][c] + helper(matrix,r+1,c,dp);
        int dl = matrix[r][c] + helper(matrix,r+1,c-1,dp);
        int dr = matrix[r][c] + helper(matrix,r+1,c+1,dp);
        
        return dp[r][c]=Math.min(Math.min(d,dl),dr);
    }
}
