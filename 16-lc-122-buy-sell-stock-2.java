class Solution {
    public int maxProfit(int[] prices) {
        Map<String,Integer> map = new HashMap<>();
       return helper(prices,0,true,map);
    }
    
    public int helper(int[] prices, int curr, boolean canBuy,Map<String,Integer> map){
        if(curr>=prices.length){
            return 0;
        }
        
        String currentKey = curr + String.valueOf(canBuy);
        if(map.containsKey(currentKey)){
            return map.get(currentKey);
        }
        
        int idle = helper(prices,curr+1,canBuy,map);
        int buy =0,sell=0;
        if(canBuy){
            buy = -prices[curr] + helper(prices,curr+1,!canBuy,map);
        }
        if(!canBuy){
         sell = prices[curr] + helper(prices,curr+1,!canBuy,map);
        }
        map.put(currentKey, Math.max(Math.max(idle,buy),sell));
        return map.get(currentKey);
    }
}


// Approach 2

class Solution {
    public int maxProfit(int[] prices) {
        int profit =0;
        for(int i=1;i<prices.length;i++){
            if(prices[i-1]<prices[i]){
                profit += prices[i]-prices[i-1];
            }
        }
        return profit;
    }
}
