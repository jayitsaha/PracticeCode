class Solution {
    public boolean isMatch(String text, String pattern) {
        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
        
        
        dp[text.length()][pattern.length()] = true;
        // So for every a matches a..fill table with true...if a mathches *..either go back two places and              see the matching or if the current character matches the i-1th character, then take the boolean              from prev row. If char dont match then F. If (.), then take the diagonal element.
        
        for (int i = text.length(); i >= 0; i--){
            
            for (int j = pattern.length() - 1; j >= 0; j--){
                
                boolean first_match = (i < text.length() && (pattern.charAt(j) == text.charAt(i) ||                                                                                             pattern.charAt(j) == '.'));
                if (j + 1 < pattern.length() && pattern.charAt(j+1) == '*'){
                    
                    dp[i][j] = dp[i][j+2] || first_match && dp[i+1][j];
                    
                } 
                
                else {
                    
                    dp[i][j] = first_match && dp[i+1][j+1];
                }
            }
        }
        
        return dp[0][0];
    }
}