class Solution {
    public int minCut(String s) {
        Map<String,Integer> map = new HashMap<>();
        return helper(s,0,s.length()-1,map);
    }
    
    public int helper(String s, int start, int end,Map<String,Integer> map){
        if(start>end){
            return 0;
        }
        
        if(isPalindrome(s,start,end)){
            return 0;
        }
        String currKey = start + "_" + end;
        if(map.containsKey(currKey)){
            return map.get(currKey);
        }
        int ans =100000000;
        for(int currentcut = start; currentcut<end ; currentcut++){
            if(isPalindrome(s,start,currentcut)){
                int right = helper(s,currentcut+1,end,map);
                ans = Math.min(ans,1+right);
            }
        }
        map.put(currKey,ans);
        return ans;
    }
    
    
    boolean isPalindrome(String str, int start, int end){
        while(start<end){
            if(str.charAt(start)!=str.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}

//TC : O(n2)
//SC : O(n2)
