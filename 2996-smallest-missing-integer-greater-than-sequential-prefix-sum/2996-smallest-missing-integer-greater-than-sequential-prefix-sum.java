import java.util.*;

class Solution {
    public int missingInteger(int[] nums) {

        // Store all numbers for quick existence checking
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        // Sum of the longest sequential prefix
        int sum = nums[0];

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] == nums[i - 1] + 1) {
                sum += nums[i];
            } else {
                break;
            }
        }

        // Find the smallest number >= sum
        // that is not present in nums
        int answer = sum;

        while (set.contains(answer)) {
            answer++;
        }

        return answer;
    }
}