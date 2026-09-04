class Solution {
    public int[] rearrangeArray(int[] nums) {

int n = nums.length;
int[]ans =new int[n];
int posi=0;
int negi=1;
for(int i=0;i<n;i++){
    if(nums[i]<0){
        ans[negi]=nums[i];
        negi+=2;
    }
    else{
        ans[posi]=nums[i];
        posi+=2;
    }
}
return ans;

    }
}