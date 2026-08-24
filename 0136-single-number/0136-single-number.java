class Solution {
    public int singleNumber(int[] nums) {

        int xorr = 0;

        // XOR all elements — duplicates cancel each other out
        for (int num : nums) {
            xorr ^= num;
        }

        return xorr;}

}