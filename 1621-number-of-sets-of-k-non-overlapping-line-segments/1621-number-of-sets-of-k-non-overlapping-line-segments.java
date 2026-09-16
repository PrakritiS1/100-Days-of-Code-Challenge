class Solution {
    static final int MOD = 1000000007;

    public int numberOfSets(int n, int k) {

        long[][] dp = new long[k + 1][n];

        // 0 segments banane ka 1 way
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int seg = 1; seg <= k; seg++) {

            long open = 0;

            for (int i = 1; i < n; i++) {

                // Start a segment from previous positions
                open = (open + dp[seg - 1][i - 1]) % MOD;

                // End the segment at i
                dp[seg][i] = open;

                // Previous completed configurations
                if (i > 0) {
                    dp[seg][i] =
                        (dp[seg][i] + dp[seg][i - 1]) % MOD;
                }
            }
        }

        return (int) dp[k][n - 1];
    }
}