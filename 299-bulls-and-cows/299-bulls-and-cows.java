class Solution {
    public String getHint(String secret, String guess) {
        
        HashMap<Integer, Integer> secretmap = new HashMap<>();
        
        int len = secret.length();
        
        for(int i=0; i<len; i++) {
            int key = secret.charAt(i)-'0';
            secretmap.put(key, secretmap.getOrDefault(key, 0)+1);
        }
        
        int bull = 0; 
        int cow = 0; 
        
        for (int i=0; i<len; i++) {
            int key = guess.charAt(i)-'0';
            int sec =  secret.charAt(i)-'0';
            
            if (key == sec) { 
                secretmap.put(key, secretmap.get(key)-1);
                bull++;
            } 
        }
        
        for (int i=0; i<len; i++) {
            int key = guess.charAt(i)-'0';
            int sec =  secret.charAt(i)-'0';
            
            if (key != sec) {
                if (secretmap.containsKey(key) && secretmap.get(key)>0) {
                    cow++;
                    secretmap.put(key, secretmap.get(key)-1);
                }
            }
        }
        
        return bull+"A"+cow+"B";
    }
}