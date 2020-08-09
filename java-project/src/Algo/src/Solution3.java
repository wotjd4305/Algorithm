package Algo.src;

import java.util.Scanner;

public class Solution3 {
    static Scanner sc = new Scanner(System.in);
    static int answer = 0;
   
    public static void main(String[] args) {
    	int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
            String input_Buffer = sc.next();
            answer = solution(input_Buffer);
            System.out.println("#" + test_case + " " + answer);
        }
    }


    public static int solution(String input)
    {
        int count = 0;
        char last_char = input.charAt(input.length()-1);
        for(int i = input.length()-2; i>=0; i--)
        {
            if(input.charAt(i) == last_char)
                continue;
            else if(input.charAt(i) != last_char)
            {
                last_char = input.charAt(i);
                count++;
            }

        }

        //ù ���ڰ� 1�̸� �ѹ��� �ٲ�����ϴ� +1
        if(input.charAt(0) == '1')
        {
            count++;
        }

        return count;
    }
}


