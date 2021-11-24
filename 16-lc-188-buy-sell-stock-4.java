class Solution {
    public int maxProfit(int k, int[] prices) {
        Map<String,Integer> map = new HashMap<>();
        return helper(prices,0,true,k,map);
    }
    
    public int helper(int[] prices, int curr, boolean canBuy,int transactionCount, Map<String,Integer> map){
        if(curr>=prices.length){
            return 0;
        }
        
        if(transactionCount<=0){
            return 0;
        }
        String currentKey = curr + String.valueOf(canBuy) + transactionCount;
        if(map.containsKey(currentKey)){
            return map.get(currentKey);
        }
        
        int idle = helper(prices,curr+1,canBuy,transactionCount,map);
        int buy =0,sell=0;
        if(canBuy){
            buy = -prices[curr] + helper(prices,curr+1,!canBuy,transactionCount,map);
        }
        if(!canBuy){
         sell = prices[curr] + helper(prices,curr+1,!canBuy,transactionCount-1,map);
        }
        map.put(currentKey, Math.max(Math.max(idle,buy),sell));
        return map.get(currentKey);
    }
}

// TC :  O(n)*O(2)*O(k) = O(2*nk) = O(n*k)
// SC : O(n*k)
