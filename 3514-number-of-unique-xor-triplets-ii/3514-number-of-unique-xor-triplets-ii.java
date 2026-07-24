class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int MAX = 2048;

        boolean[] present = new boolean[MAX];

        // Mark values present in nums
        for (int num : nums) {
            present[num] = true;
        }

        // Find all possible XORs of two values
        boolean[] pairXor = new boolean[MAX];

        for (int a = 0; a < MAX; a++) {
            if (!present[a]) continue;

            for (int b = 0; b < MAX; b++) {
                if (!present[b]) continue;

                pairXor[a ^ b] = true;
            }
        }

        // Find all possible XORs of three values
        boolean[] tripletXor = new boolean[MAX];

        for (int a = 0; a < MAX; a++) {
            if (!present[a]) continue;

            for (int x = 0; x < MAX; x++) {
                if (!pairXor[x]) continue;

                tripletXor[a ^ x] = true;
            }
        }

        int answer = 0;

        for (boolean possible : tripletXor) {
            if (possible) {
                answer++;
            }
        }

        return answer;
    }
}