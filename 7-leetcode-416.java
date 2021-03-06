class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
        }
        if(sum%2==0){
            int[][] dp = new int[nums.length+1][sum/2+1];
            return helper(nums,0,sum/2,dp);
        }
        return false;
    }
    
    public boolean helper(int[] nums, int curr, int sum,int[][] dp){
        if(sum==0){
            return true;
        }
        if(curr >= nums.length) {
            return false;
        }
        if(dp[curr][sum]!=0){
            return dp[curr][sum]==1?true:false;
        }
        boolean consider = false;
        if(nums[curr] <= sum){
            consider = helper(nums,curr+1,sum-nums[curr],dp);
        }
        boolean notConsider = helper(nums,curr+1,sum,dp);
        boolean res = consider || notConsider;
        dp[curr][sum] = res?1:2;
        return res;
    }
}
