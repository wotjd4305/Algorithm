package TextBook;

import java.util.Scanner;

public class Z12_Stack {
	static Scanner sc = new Scanner(System.in);
	public static void main(String args[]) {
			
	Stack a = new Stack();
	
	for(int i =1; i<=3; i++)
		a.push(i);
	
	for(int i =1; i<=3; i++)
		System.out.println(a.pop());
	
	}
}

class Stack{
	public static int top = -1;
	public static int stack[] = new int[100];
	
	//delete data in stack
	public static int pop()
	{
		//-1이라는 데이터가 있을수도 있기 때문에
		//예외처리를 통해 처리해줘야함.
		if(isEmpty()) {
			System.out.println("데이터 없음");
			return -1;
		}
		
		int data = stack[top];
		return stack[top--];
	}
	
	private static boolean isEmpty() {
		return top == -1;
	}

	//input in stack
	public static void push(int data)
	{
		//is full~?
		if(isFull()) {		
			System.out.println("overflow Error");
			return;
		}
		top++;
		stack[top] = data;
		return;
	}

	public static boolean isFull() {
		return top == stack.length-1;
	}
	
	
	
}