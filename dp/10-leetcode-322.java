class Solution {
    public int coinChange(int[] coins, int amount) {
        HashMap<String,Integer> memo = new HashMap<>();
        int ans =  helper(coins,0, amount,memo);
        return ans==100000?-1:ans;
    }
    
    public int helper(int[] coins, int curr, int amount,Map<String,Integer> memo){
        if(amount==0){
            return 0;
        }
        if(curr >= coins.length){
            return 100000;
        }
        String currentKey = curr + "_" + amount;
        if(memo.containsKey(currentKey)){
            return memo.get(currentKey);
        }
        int consider = 100000;        
        if(coins[curr] <= amount){
            consider = 1 + helper(coins,curr,amount-coins[curr],memo);     
        }
        int notConsider = helper(coins,curr+1,amount,memo);
        memo.put(currentKey, Math.min(consider,notConsider));
        return Math.min(consider,notConsider);
    }
}

//TC : O(n*amount)
//SC : O(n*amount)
