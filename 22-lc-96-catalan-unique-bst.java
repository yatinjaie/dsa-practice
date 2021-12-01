class Solution {
    public int numTrees(int n) {
        HashMap<Integer,Integer> map = new HashMap<>();
        return nthCatalan(n,map);
    }
    
    public  int nthCatalan(int n,HashMap<Integer,Integer> map ){
        if(n<=1){
            return 1;
        }
        if(map.containsKey(n)){
            return map.get(n);
        }
        int res = 0;
        for(int i=0;i<n;i++){
            res += nthCatalan(i,map) * (nthCatalan(n-i-1,map));
        }
        map.put(n,res);
        return res;
        
    }
}
