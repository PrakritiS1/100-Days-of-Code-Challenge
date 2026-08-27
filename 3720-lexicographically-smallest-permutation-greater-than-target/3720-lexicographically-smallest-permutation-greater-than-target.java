import java.util.*;

class Solution {

    String mini;

    public void solve(int i, String s, String target, int[] count) {

        int n = target.length();

        // Base case
        if (i == n) {
            if (s.compareTo(target) > 0) {
                if (s.compareTo(mini) < 0) {
                    mini = s;
                }
            }
            return;
        }

        // Case 1: Use the same character as target[i]
        int currentChar = target.charAt(i) - 'a';

        if (count[currentChar] > 0) {

            count[currentChar]--;

            solve(
                i + 1,
                s + target.charAt(i),
                target,
                count
            );

            // Backtracking
            count[currentChar]++;
        }

        // Case 2: Find the smallest available character
        // greater than target[i]
        for (int j = currentChar + 1; j < 26; j++) {

            if (count[j] > 0) {

                StringBuilder temp = new StringBuilder(s);

                // Add greater character
                temp.append((char) ('a' + j));
                count[j]--;

                // Add all remaining characters
                // in sorted ascending order
                for (int k = 0; k < 26; k++) {
                    while (count[k] > 0) {
                        temp.append((char) ('a' + k));
                        count[k]--;
                    }
                }

                String candidate = temp.toString();

                if (candidate.compareTo(mini) < 0) {
                    mini = candidate;
                }

                return;
            }
        }
    }

    public String lexGreaterPermutation(String s, String target) {

        int[] count = new int[26];

        // Sort s in descending order
        char[] arr = s.toCharArray();
        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder(
            new String(arr)
        );

        String largest = sb.reverse().toString();

        // If even the largest permutation is <= target,
        // no answer exists
        if (largest.compareTo(target) <= 0) {
            return "";
        }

        mini = largest;

        // Count frequency of characters
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        solve(0, "", target, count);

        return mini;
    }
}