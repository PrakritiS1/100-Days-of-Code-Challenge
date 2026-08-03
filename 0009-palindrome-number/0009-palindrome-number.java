
import java.util.Scanner;
class Solution {
    public boolean isPalindrome(int x) {
       
      int  c=x;//assign value to c to x that we can compare it
 int s=0;
        //for that we have to apply loo[]
  while(x>0){
   int r=x%10;
    s=(s*10)+r;
    x=x/10;

  }
  if(c==s){
    
return true;
  }
   else{
     
return false;
   }     
    }
}