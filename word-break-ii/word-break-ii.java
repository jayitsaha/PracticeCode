class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        
        
        HashSet<String> set = new HashSet<>(wordDict);
        if (s.length() == 0 ) return new ArrayList<>();
        char[] chars = s.toCharArray();
        List<String>[] dp = new List[chars.length];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            dp[i] = new ArrayList<>();
            sb.setLength(0);
            for (int j = i; j >= 0; j--) {
                sb.insert(0, chars[j]);
                String word = sb.toString();
                if(set.contains(word)) {
                    if (j == 0) {
                        dp[i].add(word);
                    } else {
                        for (String prev : dp[j - 1]) {
                            dp[i].add(prev + " " + word);
                        }
                    }
                }
            }
        }
        return dp[chars.length - 1];
        
        
        
    }
}