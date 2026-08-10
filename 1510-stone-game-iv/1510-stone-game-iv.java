class Solution {
    public boolean winnerSquareGame(int n) {
        boolean dp[]=new boolean[n+1];
    for(int i=1;i<=n;i++){

      for(int j=1;j*j<=i;j++){
        int square = j * j;

                // If after our move opponent is in a losing state,
                // then current player can win.
                if (!dp[i - square]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}