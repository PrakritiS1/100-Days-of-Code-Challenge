class Solution {
    public String shortestBeautifulSubstring(String s, int k) {

        int left = 0;
        int count = 0;

        String best = "";

        for (int right = 0; right < s.length(); right++) {

            // Add current character
            if (s.charAt(right) == '1') {
                count++;
            }

            // We have exactly k ones
            while (count == k) {

                // Remove unnecessary leading zeros
                while (left <= right && s.charAt(left) == '0') {
                    left++;
                }

                String current = s.substring(left, right + 1);

                // Compare with current answer
                if (best.equals("")
                        || current.length() < best.length()
                        || (current.length() == best.length()
                            && current.compareTo(best) < 0)) {

                    best = current;
                }

                // Move left forward
                if (s.charAt(left) == '1') {
                    count--;
                }

                left++;
            }
        }

        return best;
    }
}