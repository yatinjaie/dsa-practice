class Solution {
    public int jump(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        return minJumps(nums,0,map);
    }
    
    public int minJumps(int[] nums, int curr, Map<Integer,Integer> map){
        if(curr>=nums.length-1){
            return 0;
        }
        int currentKey = curr;
        if(map.containsKey(currentKey)){
            return map.get(currentKey);
        }
        int currJump = nums[curr];
        int ans = 10001;
        for(int i=1;i<=currJump;i++){
           ans = Math.min(ans, 1+ minJumps(nums,curr+i,map));
        }
        map.put(currentKey,ans);
        
        return ans;
        
    }
}

// TC : O(N*nums(max))
// SC : O(N)
