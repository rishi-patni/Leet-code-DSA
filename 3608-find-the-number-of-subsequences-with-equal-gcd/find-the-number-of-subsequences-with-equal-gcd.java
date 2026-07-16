class Solution {
    static final int MOD = 1_000_000_007;
    int[] nums;
    int[][][] dp;

    public int subsequencePairCount(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        dp = new int[n][201][201];

        for (int[][] a : dp)
            for (int[] b : a)
                Arrays.fill(b, -1);

        return dfs(0, 0, 0);
    }

    private int dfs(int i, int g1, int g2) {
        if (i == nums.length)
            return (g1 == g2 && g1 != 0) ? 1 : 0;

        if (dp[i][g1][g2] != -1)
            return dp[i][g1][g2];

        long ans = dfs(i + 1, g1, g2);

        ans += dfs(i + 1, gcd(g1, nums[i]), g2);
        ans += dfs(i + 1, g1, gcd(g2, nums[i]));

        return dp[i][g1][g2] = (int) (ans % MOD);
    }

    private int gcd(int a, int b) {
        return a == 0 ? b : gcd(b % a, a);
    }
}