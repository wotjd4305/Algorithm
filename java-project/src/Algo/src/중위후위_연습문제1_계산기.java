package Algo.src;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;


public class 중위후위_연습문제1_계산기 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String args[]) {

		String[] input = { "2","3","15","5","/","*","+"};
		HashMap<String, Integer> isp = new HashMap<>();
		HashMap<String, Integer> icp = new HashMap<>();
		Stack<String> st = new Stack<>();
		
		
		isp.put("*", 2);
		icp.put("*", 2);
		isp.put("/", 2);
		icp.put("/", 2);
		isp.put("+", 2);
		icp.put("+", 2);
		isp.put("-", 1);
		icp.put("-", 1);
		isp.put("(", 0);
		icp.put("(", 3);	
		
		for(String str: input) {
			if(Character.isDigit(str.charAt(0)))
				System.out.print(str + " ");
			else {
				
				//1) )가 입력이 될떄
				if(str.equals(")")){
					while(!st.isEmpty()) {
						if(st.peek().equals("("))
								break;
						else
							System.out.println(str + " ");
					}
				}
				
				//2) 나머지 우선순위에 따라서
				
				
				
				
			}
		}
		
		
		
	}
}

