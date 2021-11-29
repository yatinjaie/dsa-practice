class Solution {
    int MOD = 1000000000 + 7;
    public int numRollsToTarget(int d, int f, int target) {
        HashMap<String,Integer> map = new HashMap<>();
        return totalWays(d,f,target,map);
    }
    
    public int totalWays(int d, int f, int target,HashMap<String,Integer> map){
        if(d==0 && target ==0){
            return 1;
        }
        if(d==0 || target==0){
            return 0;
        }
        String currentKey = d +"_"+target;
        if(map.containsKey(currentKey)){
            return map.get(currentKey);
        }
        int ans = 0;
        for(int i=1;i<=f;i++){
            ans = (ans  + totalWays(d-1,f,target-i,map)) % MOD;
        }
        map.put(currentKey,ans);
        return ans;
    }
}
