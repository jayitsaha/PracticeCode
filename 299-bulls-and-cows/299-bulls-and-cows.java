class Solution {
    public String getHint(String secret, String guess) {
        
        HashMap<Integer, Integer> secretmap = new HashMap<>();
        
        int len = secret.length();
        
        for(int i=0; i<len; i++) {
            int digit = secret.charAt(i)-'0';
            secretmap.put(digit, secretmap.getOrDefault(digit, 0)+1);
        }
        
        int bull = 0; 
        int cow = 0; 
        
        for (int i=0; i<len; i++) {
            int digit = guess.charAt(i)-'0';
            int match =  secret.charAt(i)-'0';
            
            if (digit == match) { 
                secretmap.put(digit, secretmap.get(digit)-1);
                bull++;
            } 
        }
        
        for (int i=0; i<len; i++) {
            int digit = guess.charAt(i)-'0';
            int match =  secret.charAt(i)-'0';
            
            if (digit != match) {
                if (secretmap.containsKey(digit) && secretmap.get(digit)>0) {
                    cow++;
                    secretmap.put(digit, secretmap.get(digit)-1);
                }
            }
        }
        
        return bull+"A"+cow+"B";
    }
}