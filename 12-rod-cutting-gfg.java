class Solution{
    public int cutRod(int price[], int n) {
        int dp[][] = new int[1001][1001];
        for(int i=0;i<1001;i++){
            for(int j=0;j<1001;j++){
                dp[i][j]=-1;
            }
        }
        return helper(price,0,n,dp);
    }
    
    public int helper(int[] price, int curr, int l,int dp[][]){
        
        
        if(l==0 || curr == price.length){
            return 0;
        }
        
        if(dp[curr][l] !=-1){
            return dp[curr][l];
        }
        
        int consider = 0;
        if(l>curr){
            consider = price[curr] + helper(price, curr, l-(curr+1),dp);
        }
        int notConsider = helper(price, curr+1, l,dp);
        
        return dp[curr][l]=Math.max(consider,notConsider);
        
    }

    
}
