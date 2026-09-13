class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int maxOverlap = 0;

        // Try every possible row shift
        for (int dx = -(n - 1); dx <= n - 1; dx++) {

            // Try every possible column shift
            for (int dy = -(n - 1); dy <= n - 1; dy++) {

                int overlap = 0;

                // Check every cell of img1
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {

                        int ni = i + dx;
                        int nj = j + dy;

                        // Check if shifted cell is inside img2
                        if (ni >= 0 && ni < n && nj >= 0 && nj < n) {

                            if (img1[i][j] == 1 && img2[ni][nj] == 1) {
                                overlap++;
                            }
                        }
                    }
                }

                maxOverlap = Math.max(maxOverlap, overlap);
            }
        }

        return maxOverlap;
    }
}