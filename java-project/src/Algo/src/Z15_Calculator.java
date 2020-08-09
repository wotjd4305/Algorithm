package Algo.src;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

/**
 * 
 * 계산기 1 중위표기식 => 후기표기식(스택을사용) 6 + 5 * ( 2 - 8 ) / 2 -9
 * 
 *
 */

public class Z15_Calculator {
	public static void main(String args[]) throws FileNotFoundException {
		//파일입력처리
		System.setIn(new FileInputStream("Test.txt"));
		Scanner sc = new Scanner(System.in);

		//문자열 입력처리
		String string = "6 + 5 * ( 2 - 8 ) / 2";
		//System.in -> 사용자에서 입력을 가져와
		//StringReader -> 문자열에서 가져와
		//Scanner sc = new Scanner(new StringReader(string));
		
		String str_input = sc.nextLine();
		String[] srr = str_input.split(" ");

		char[] stackOp = new char[20];
		int top = -1;

		//( 6 + 5 * ( 2 - 8 ) / 2 )
		//6 5 2 8 - * 2 / + 
		for (int i = 0; i < srr.length; i++) {// 배열만큼 반복
			char c = srr[i].charAt(0);
			// 해싱기법 가장빠른 검색!(상수시간)
			switch (c) {
			case '(': // 스택에 무조건 넣는다
				stackOp[++top] = c;
				break;
			case '*': // 스택에 2보다 작은 우선순위가 있을 떄까지 꺼내서 출력
			case '/': // 낮은 우선순위가 나올때 까지..
				while (top >= 0 && (stackOp[top] == '/' || stackOp[top] == '*')) {
					System.out.print(stackOp[top--] + " ");
				}
				stackOp[++top] = c;
				break;
			case '+': // 스택에 1보다 작은 우선순위가 있을 때 까지 꺼내서 출력
			case '-':
				while (top >= 0
						&& (stackOp[top] == '/' || stackOp[top] == '*' || stackOp[top] == '+' || stackOp[top] == '-')) {
					System.out.print(stackOp[top--] + " ");
				}
				stackOp[++top] = c;
				break;
			case ')': // ( 여는 괄호가 나올때까지 모두뺴서 출력
				while (top >= 0 && stackOp[top] != '(') {
					System.out.print(stackOp[top--] + " ");
				}
				if (top >= 0 && stackOp[top] == '(') {// 괄호가있겠찌만 확인해줌.
					top--;
				}
				break;
			default: // 피연산
				System.out.print(srr[i] + " ");
				break;
			}//switch
		}//for
		
		//남아있을경우 다 꺼내자
		while(top >-1) {
			System.out.print(stackOp[top] + " ");
		}
		
	}// main
}// class