import java.util.*;

class Solution {
    public int totalNumbers(int[] digits) {

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < digits.length; i++) {

            // First digit cannot be 0
            if (digits[i] == 0)
                continue;

            for (int j = 0; j < digits.length; j++) {

                // Same digit/index cannot be used again
                if (i == j)
                    continue;

                for (int k = 0; k < digits.length; k++) {

                    // Same digit/index cannot be used again
                    if (i == k || j == k)
                        continue;

                    // Last digit must be even
                    if (digits[k] % 2 != 0)
                        continue;

                    // Create the 3-digit number
                    int num = digits[i] * 100
                            + digits[j] * 10
                            + digits[k];

                    // Store only distinct numbers
                    set.add(num);
                }
            }
        }

        return set.size();
    }
}