class Solution {
    public int numSquares(int n) {
        int[] nums = new int[(int)Math.sqrt(n)]; 
        int j=0;
        for(int i=(int)Math.sqrt(n);i>0;i--){
            nums[j++] = i;
        }
        Map<String,Integer> map = new HashMap<>();
        return helper(nums,0,n,map);
    }
    
    public int helper(int[] nums, int curr, int n, Map<String,Integer> map){
        if(n==0){
            return 0;
        }
        if(curr >= nums.length){
            return 10001;
        }
        String currentKey = curr + "_" + n;
        if(map.containsKey(currentKey)){
            return map.get(currentKey);
        }
        
        int notConsider = helper(nums, curr+1,n,map);
        int consider = 10001;
        if(n>=Math.pow(nums[curr],2)){
           consider  = 1 + helper(nums,curr,n-(nums[curr]*nums[curr]),map);
        }
        map.put(currentKey,Math.min(consider,notConsider));
        return Math.min(consider,notConsider);
    }
    
}
