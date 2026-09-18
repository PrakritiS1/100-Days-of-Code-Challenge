class Solution {
    public List<String> maxNumOfSubstrings(String s) {

        int n = s.length();

        int[] first = new int[26];
        int[] last = new int[26];

        Arrays.fill(first, -1);

        // 1. Find first and last occurrence of every character
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';

            if (first[c] == -1) {
                first[c] = i;
            }

            last[c] = i;
        }

        // 2. Find all valid intervals
        List<int[]> intervals = new ArrayList<>();

        for (int c = 0; c < 26; c++) {

            if (first[c] == -1) {
                continue;
            }

            int start = first[c];
            int end = last[c];

            boolean valid = true;

            // Expand interval if required
            for (int i = start; i <= end; i++) {

                int current = s.charAt(i) - 'a';

                // This character appeared before our start
                if (first[current] < start) {
                    valid = false;
                    break;
                }

                // We must include all occurrences of this character
                end = Math.max(end, last[current]);
            }

            if (valid) {
                intervals.add(new int[]{start, end});
            }
        }

        // 3. Sort intervals by ending position
        intervals.sort((a, b) -> Integer.compare(a[1], b[1]));

        // 4. Greedy selection
        List<String> ans = new ArrayList<>();

        int prevEnd = -1;

        for (int[] interval : intervals) {

            int start = interval[0];
            int end = interval[1];

            if (start > prevEnd) {

                ans.add(s.substring(start, end + 1));

                prevEnd = end;
            }
        }

        return ans;
    }
}