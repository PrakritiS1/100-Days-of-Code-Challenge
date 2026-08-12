class Solution {
    public int maxSubarrayLength(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < nums.length; right++) {

            int num = nums[right];

            // Add current element
            map.put(num, map.getOrDefault(num, 0) + 1);

            // If frequency becomes greater than k
            while (map.get(num) > k) {

                int leftNum = nums[left];

                map.put(leftNum, map.get(leftNum) - 1);

                left++;
            }

            // Current window is valid
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}