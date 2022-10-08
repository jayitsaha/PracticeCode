class Solution {
    public int[] countBits(int n) {
        int[] dp = new int[n+1];
        for (int i = 0; i <= n; i++) {
           dp[i] = (i % 2 == 0) ? dp[i/2] : 1 + dp[i/2];
        }
        return dp;
    }
}
