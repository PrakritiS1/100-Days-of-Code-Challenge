class Solution {
    public List<Integer> grayCode(int n) {
    List<Integer> grey=new ArrayList<>();
    grey.add(0);
    if(n==0)return grey;
    grey.add(1);
    int curr=1;
    for(int i=2;i<=n;i++){
        curr *=2;
        for(int j=grey.size()-1;j>=0;j--){
grey.add(curr+grey.get(j));
        }
    }
    return grey;    
    }
}