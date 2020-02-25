import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class bac2231_분해합 {
    static Scanner sc = new Scanner(System.in);
    static int answer = 0;

    public static void main(String[] args) {

        int input = sc.nextInt();
        solution(input);
        System.out.println(answer);

    }

    public static void solution(int input)
    {
        for(int i =0; i<input; i++)
        {
            String buffer = "" +i;
            int dst_value_i = 0;

            for(int j=0; j<buffer.length(); j++)
            {
                dst_value_i += Integer.parseInt("" + buffer.charAt(j));
            }
            dst_value_i +=  i;
            if(dst_value_i == input) {
                answer = i;
                break;
            }
        }
    }
}