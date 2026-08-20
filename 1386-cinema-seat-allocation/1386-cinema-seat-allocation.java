class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

      int res=n*2;
      int j=0;
     Arrays.sort(reservedSeats, (a, b) -> {

    if (a[0] == b[0]) {
        return Integer.compare(a[1], b[1]);
    } 
    else {
        return Integer.compare(a[0], b[0]);
    }
});
      while(j<reservedSeats.length){
        int curr_row=reservedSeats[j][0];
    boolean isle1 = false;
boolean isle2left = false;
boolean isle2right = false;
boolean isle3 = false;
    while(j<reservedSeats.length && reservedSeats[j][0]==curr_row){
         int seat=reservedSeats[j][1];
         if(seat==2 || seat==3){
isle1=true;
         }
         else if(seat==4 ||seat==5){
            isle2left=true;
         }
          else if(seat==6 ||seat==7){
            isle2right=true;
         }
          else if(seat==8 ||seat==9){
            isle3=true;
         }
         j++;
    }
   if ((isle1  && isle2right)||(isle3 && isle2left)||(isle2left && isle2right)){
        res-=2;
   }
               
            else if( isle1 || isle2left ||isle2right || isle3 ){
                res-=1;
            }


      }
return res;
    }
}