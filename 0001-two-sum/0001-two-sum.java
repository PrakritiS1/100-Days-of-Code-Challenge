class Solution {
    public int[] twoSum(int[] nums, int target) {
        
    HashMap<Integer,Integer> h=new HashMap<>();
    for(int i=0;i<nums.length;i++){
        int remain=target-nums[i];
        if(h.containsKey(remain)){
            return new int[]{h.get(remain),i};
        }
        h.put(nums[i],i);
    }
    return new int[]{};
    }
}