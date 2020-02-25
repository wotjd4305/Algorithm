import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class swe5356 {
      static Scanner sc = new Scanner(System.in); 
      static String[] StrArr = new String[5];
    
    public static void main(String[] args) {

    	String answer = "";
        int T = sc.nextInt();

        //테스트케이스
        for(int t=0; t<T; t++) {
        	
        	Arrays.fill(StrArr, "");
        	answer = solution();

            System.out.println("#"+ (t+1) + " " + answer);
        }


    }

    public static String solution()
    {
    	 
       String answer = "";
      for(int i =0; i <5; i ++)
      {
    	  StrArr[i] = sc.next();
      }
      
      for(int i =0; i <15; i++)
    	  {
	    	  for(int j = 0; j<5; j++)
	    	  {
	    		  if(StrArr[j].length() <= i)
	    			  continue;
	
	    		  answer = answer + StrArr[j].charAt(i);
	    	  }
	    }
      
      return answer;
    }
 


}