import java.util.*;
public class BowlingGame {

    
    public int score(char cc)
    {
      if(cc=='X')return 10;
      if(cc=='-')return 0;
      if(cc=='/')return 10;
      return cc- 48;
      
    }
    public int getOneFrame(int i ,String[] s){
      int sum =0 ;
      // i =8 =======================================
      if(i==8)
      {
       if(s[i].charAt(0)=='X')
       {
         sum +=10;

         if(s[i+1].charAt(0)=='X')
         {
           sum +=10;
           sum += score(s[i+3].charAt(0));
         }
         else 
         {
           int temp =0 ;
           temp += score(s[i+1].charAt(0));
           if(s[i+1].charAt(1)=='/')temp=10;
           else temp += score(s[i+1].charAt(1));
           sum += temp;
         }
       }else
       {
         sum += score(s[i].charAt(0));
         if(s[i].charAt(1)=='/')
         {
           sum += 10 -score(s[i].charAt(0));
           sum += score(s[i+1].charAt(0));
         }
         else{
           sum += score(s[i].charAt(1));
         }
       }
      }
      // i =9 =========================================
      if(i==9)
      {
         if(s[i].charAt(0)=='X')
         {
           sum += 10;
           sum += score(s[i+2].charAt(0)) + score(s[i+2].charAt(1));
         }
         else{
           sum += score(s[i].charAt(0));
           if(s[i].charAt(1)=='/')
           {
             sum+= 10 - score(s[i].charAt(0));
             sum+= score(s[i+2].charAt(0)); 
           }else{
             sum += score(s[i].charAt(1));
           }
         }
      }
      //   i!=8 && i!=9============================
      if(i!=8&&i!=9)
      {
        if(s[i].charAt(0)=='X')
        {
           sum +=10;
           if(s[i+1].charAt(0)=='X'){
             sum +=10;
             sum += score(s[i+2].charAt(0));
           }else
           {
             sum += score(s[i+1].charAt(0));
             if(s[i+1].charAt(1)=='/')
                sum += 10 - score(s[i+1].charAt(0));
             else
                sum += score(s[i+1].charAt(1));
           }
        }
        else
        {
           sum += score(s[i].charAt(0));
           if(s[i].charAt(1)=='/')
           {
              sum += 10 - score(s[i].charAt(0));
              sum += score(s[i+1].charAt(0));
           }else
           {
              sum += score(s[i].charAt(1));
           }
        }
      //=============================================
      
      }

      return sum;
    }
    public int getBowlingScore(String bowlingCode) {
     String []s = bowlingCode.split("\\|");
     int sum =0;
     for(int i =0 ; i< 10; i++)
         sum += getOneFrame(i, s); 
          return sum;
     }
  /*
   public static void main(String args[]){
      Scanner scanner = new Scanner(System.in);
      String str = scanner.nextLine();
      BowlingGame game = new BowlingGame();
      System.out.println(game.getBowlingScore(str));
   }
*/
}
