//Target Sum
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<String,Integer> memo = new HashMap<>();
        return helper(nums,0,target,memo);
    }
    
    public int helper(int[] nums, int curr, int target,Map<String,Integer> memo){
        if(target ==0 && curr>=nums.length){
            return 1;
        }
        String currentKey = curr + "_" + target;
        if(curr>=nums.length){
            return 0;
        }
        if(memo.containsKey(currentKey)){
            return memo.get(currentKey);
        }
        int plus = helper(nums,curr+1,target-nums[curr],memo);
        int negative = helper(nums,curr+1,target+nums[curr],memo);
        memo.put(currentKey, plus+negative);
        return plus+negative;
        
    }
}
//TC : O(n*target)
//OC : O(n*target)
