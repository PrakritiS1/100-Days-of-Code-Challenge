class Solution {
    public int minOperations(int[] nums, int x) {

        int totalSum = 0;

        // Calculate total sum
        for (int num : nums) {
            totalSum += num;
        }

        // We need to keep a subarray
        int target = totalSum - x;

        // Impossible
        if (target < 0) {
            return -1;
        }

        int left = 0;
        int currentSum = 0;
        int maxLength = -1;

        // Sliding Window
        for (int right = 0; right < nums.length; right++) {

            currentSum += nums[right];

            // If sum becomes greater than target
            while (currentSum > target && left <= right) {
                currentSum -= nums[left];
                left++;
            }

            // Found a subarray with target sum
            if (currentSum == target) {
                maxLength = Math.max(
                    maxLength,
                    right - left + 1
                );
            }
        }

        // No valid subarray found
        if (maxLength == -1) {
            return -1;
        }

        // Remove everything outside the subarray
        return nums.length - maxLength;
    }
}