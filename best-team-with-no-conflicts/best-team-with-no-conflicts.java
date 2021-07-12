class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        List<Pair> l = new ArrayList<>();
        for (int i = 0; i < ages.length; i++) {
            l.add(new Pair(ages[i], scores[i]));
        }
        Collections.sort(l, (p1, p2) -> {
            return p1.age == p2.age ? p1.score - p2.score : p1.age - p2.age;
        });
        int[] dp = new int[l.size()];
        dp[0] = l.get(0).score;
        int max = dp[0];
        for (int i = 1; i < l.size(); i++) {
            dp[i] = l.get(i).score;
            for (int j = 0; j < i; j++) {
                if (l.get(j).score <= l.get(i).score) 
                    dp[i] = Math.max(dp[i], dp[j] + l.get(i).score);
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
    
    class Pair {
        int score;
        int age;
        public Pair(int age, int score) {
            this.age = age;
            this.score = score;
        }
        
    }
}