static int maximumPath(int N, int Matrix[][])
    {
        int max = 0;
        int m = Matrix.length;
        int n = Matrix[0].length;
        int dp[][] = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                dp[i][j]= -1;
            }
        }
        for( int i=0;i<Matrix.length ;i++){
            max = Math.max(max,helper(Matrix,0,i,dp));
        }
        return max;
    }
    
    static int helper(int[][] matrix ,  int r, int c,int dp[][]){
        int m = matrix.length;
        int n = matrix[0].length;
        if(r<0 || c <0 || r>m-1 || c> n-1){
            return 0;
        }
        if(dp[r][c]!=-1){
            return dp[r][c];
        }
        if(r==m){
            return matrix[r][c];
        }
        
        int d = matrix[r][c] + helper(matrix,r+1,c,dp);
        int dl = matrix[r][c] + helper(matrix,r+1,c-1,dp);
        int dr = matrix[r][c] + helper(matrix,r+1,c+1,dp);
        
        return dp[r][c]=Math.max(Math.max(d,dl),dr);
    }
    
    //https://practice.geeksforgeeks.org/problems/path-in-matrix3805/1#
