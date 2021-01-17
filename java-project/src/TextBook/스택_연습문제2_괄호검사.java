package TextBook;

import java.util.Scanner;

public class 스택_연습문제2_괄호검사 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String args[]) {

		//스택은 넉넉하게~	
		String input_str[] = sc.next().split("");		
		int top = -1;
		String result = "짝 완성";
		
		for(int i =0; i<input_str.length; i++) {
			if(input_str[i].equals("("))
				++top;
			else {
				if(top == -1) {
					result = "짝 X";
					break;
				}
				--top;
			}	
		}
		//스택이 비었는가?
		if(top != -1)
			result = "짝 X";
		
		//결과출력
		System.out.println(result);		
	}
}

