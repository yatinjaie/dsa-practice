class Solution {
    public int maxProfit(int[] prices) {
        Map<String,Integer> map = new HashMap<>();
        return helper(prices,0,true,1,map);
    }
    
    public int helper(int[] prices, int curr, boolean canBuy,int transactionCount, Map<String,Integer> map){
        if(curr>=prices.length){
            return 0;
        }
        
        if(transactionCount==0){
            return 0;
        }
        String currentKey = curr + String.valueOf(canBuy) + transactionCount;
        if(map.containsKey(currentKey)){
            return map.get(currentKey);
        }
        
        int idle = helper(prices,curr+1,canBuy,transactionCount,map);
        int buy =0,sell=0;
        if(canBuy){
            buy = -prices[caurr] + helper(prices,curr+1,!canBuy,transactionCount,map);
        }
        if(!canBuy){
         sell = prices[curr] + helper(prices,curr+1,!canBuy,0,map);
        }
        map.put(currentKey, Math.max(Math.max(idle,buy),sell));
        return map.get(currentKey);
    }
}

// TC :  O(n)*O(2)*O(1) = O(2*n) = O(n)
// SC : O(n)


//Approach 2:

public class Solution {
    public int maxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }
}
