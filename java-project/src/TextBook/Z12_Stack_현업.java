package TextBook;

import java.util.Scanner;
import java.util.Stack;

public class Z12_Stack_현업 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String args[]) {
			
	Stack<Object> st = new Stack<>();
	
	//스택은 넉넉하게~
	int stack[] = new int[3];
	int topp = -1;
	stack[++topp] = 10;
	stack[++topp] = 20;
	stack[++topp] = 30;	
	System.out.println(stack[topp--]);
	System.out.println(stack[topp--]);
	System.out.println(stack[topp--]);
	
	
	
	/*st.push(4);
	st.push(5);
	st.push(6);
	
	while(!st.isEmpty())
		System.out.println(st.pop());
	*/
	
	
	
	}
}
