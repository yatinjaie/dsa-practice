class Solution {
    public int change( int amount,int[] coins) {
        HashMap<String,Integer> memo = new HashMap<>();
        int ans =  helper(coins,0, amount,memo);
        return ans;
    }
    
    public int helper(int[] coins, int curr, int amount,Map<String,Integer> memo){
        if(amount==0){
            return 1;
        }
        if(curr >= coins.length){
            return 0;
        }
        String currentKey = curr + "_" + amount;
        if(memo.containsKey(currentKey)){
            return memo.get(currentKey);
        }
        int consider = 0;        
        if(coins[curr] <= amount){
            consider = helper(coins,curr,amount-coins[curr],memo);     
        }
        int notConsider = helper(coins,curr+1,amount,memo);
        memo.put(currentKey, consider + notConsider);
        return consider + notConsider;
    }
}

//TC : O(n*amount)
//SC : O(n*amount)
