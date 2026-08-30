class Solution {
    public int minimumDeletions(int[] nums) {
      int minindex=0;
      int maxindex=0;
      int n=nums.length;
      for(int i=0;i<n;i++){
        if(nums[i]<nums[minindex]){
        minindex=i;
        }
          if (nums[i] > nums[maxindex]) {
        maxindex = i;
      }}
       // Ensure minIndex is the smaller position
        int left = Math.min(minindex, maxindex);
        int right = Math.max(minindex, maxindex);

        // Three possible ways
        int fromFront = right + 1;
        int fromBack = n - left;
        int fromBothSides = left + 1 + n - right;

        return Math.min(fromFront,
               Math.min(fromBack, fromBothSides));
    }
}