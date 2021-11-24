class Solution {
    public int maxProfit(int[] prices, int fee) {
        Map<String,Integer> map = new HashMap<>();
        return helper(prices,0,true,fee,map);
    }
    
    public int helper(int[] prices, int curr, boolean canBuy,int fee,Map<String,Integer> map){
        if(curr>=prices.length){
            return 0;
        }
        
        String currentKey = curr + String.valueOf(canBuy);
        if(map.containsKey(currentKey)){
            return map.get(currentKey);
        }
        
        int idle = helper(prices,curr+1,canBuy,fee,map);
        int buy =0,sell=0;
        if(canBuy){
            buy = -prices[curr] + helper(prices,curr+1,!canBuy,fee,map);
        }
        if(!canBuy){
         sell = prices[curr] - fee + helper(prices,curr+1,!canBuy,fee,map);
        }
        map.put(currentKey, Math.max(Math.max(idle,buy),sell));
        return map.get(currentKey);
    }
}
