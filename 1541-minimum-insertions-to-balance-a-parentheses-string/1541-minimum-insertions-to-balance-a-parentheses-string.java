
class Solution {
    public int minInsertions(String s) {
        int open = 0;
        int insertions = 0;
        int i = 0;

        while (i < s.length()) {
            if (s.charAt(i) == '(') {
                open++;
                i++;
            } else {
                // Check if next character is also ')'
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    i += 2;
                } else {
                    // Insert one ')' to make a pair
                    insertions++;
                    i++;
                }

                // No opening bracket available
                if (open == 0) {
                    insertions++;
                } else {
                    open--;
                }
            }
        }

        // Each unmatched '(' needs two ')'
        insertions += open * 2;

        return insertions;
    }
}