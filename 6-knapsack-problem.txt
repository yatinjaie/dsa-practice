static int knapSack(int W, int wt[], int val[], int n) 
    { 
        HashMap<String,Integer> map = new HashMap<>();
         return helper(W,wt,val,n,0,map);
    } 
    
    static int helper(int capacity, int wt[], int val[], int n, int curr,Map<String,Integer> map){
        if(curr >= n){
            return 0;
        }
        String currentKey = curr + "_"+ capacity;
        if(map.containsKey(currentKey)){
            return map.get(currentKey);
        }
        int consider =0;
        if(wt[curr]<=capacity ){
            consider = val[curr] + helper(capacity-wt[curr],wt,val,n,curr+1,map);
        }
        int notConsider = helper(capacity,wt,val,n,curr+1,map);
        map.put(currentKey,Math.max(consider,notConsider));
        return Math.max(consider,notConsider);
    }
    
    //TC : O(n*w)
    //Aux SC : O(n*w) 
