import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class swe5688 {
      static Scanner sc = new Scanner(System.in); 
      static String[] StrArr = new String[5];
    
    public static void main(String[] args) {

    	double answer = 0;
        int T = sc.nextInt();

        //�׽�Ʈ���̽�
        for(int t=0; t<T; t++) {
        	
        	double input = sc.nextDouble();
        	answer = solution(input);

            System.out.println("#"+ (t+1) + " " + answer);
        }


    }

    public static double solution(double input)
    {
    	double result = 0;
    	
    	result = Math.sqrt(Math.sqrt(input));
    	double compare_value = Math.pow(result, 3);
    	System.out.println();
    	
    	if(compare_value == result )
    		return result;
    	else
    		return -1;
    	     
    }
 


}