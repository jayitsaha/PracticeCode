class Solution {
    
    class Pair implements Comparable<Pair>{
        
        int w , h;
        Pair(int w, int h){
            
            this.w = w;
            this.h = h;
        }
        
        
        public int compareTo(Pair o){
            
            return this.w - o.w;
        }
        
    }
    
    
    public int LIS(Pair[] pairs, int n){
        
        int dp[] = new int[n];
        
        int omax = 0;
        
        for(int i=0;i<n;i++){
            int max = 0;
            
            for(int j=0;j<i;j++){
                
                if(pairs[j].h<pairs[i].h && pairs[j].w<pairs[i].w){
                    
                    if(dp[j] > max)
                        max = dp[j];
                }
            }
            
            dp[i] = max + 1;
            
            if(dp[i] > omax)
                omax = dp[i];
            
        }
        
        return omax;
    }
    
    
    public int maxEnvelopes(int[][] envelopes) {
        
        int i=0;
        
        Pair pairs[] = new Pair[envelopes.length];
        
        for(int [] e: envelopes){
            
            Pair t = new Pair(e[0],e[1]);
            pairs[i++] = t;
            
        }
        
        Arrays.sort(pairs);
        
        return LIS(pairs, pairs.length);
        
        
    }
}