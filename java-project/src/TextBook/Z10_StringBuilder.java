package TextBook;

import java.util.Scanner;
/**
 * String
 * StringBuilder 멀티쓰레드용
 * StringBuffer 단일쓰레드용
 */

public class Z10_StringBuilder {
	static Scanner sc = new Scanner(System.in);
	public static void main(String args[]) {
		
		//원래 문자열은 변경x
		String str = "hello";
		System.out.println(str + "a");
		System.out.println(str.concat("a"));
		
		//알고리즘은 Builder, 여유공간
		StringBuilder sb = new StringBuilder("hello");//빈공간이 16칸 다시 늘어남
		System.out.println(sb);
		System.out.println(sb.append("a")); // 메소드 호출후 원본 변경
		System.out.println(sb);
		System.out.println(sb.reverse());
		
		//String -> StringBuilder로 변경
		String s = "apple";
		StringBuilder sbb = new StringBuilder(s);
		System.out.println(sbb); // apple
		System.out.println(sbb.reverse()); // elppa
		
		//StringBuilder -> String
		s = sbb.toString();
		System.out.println(s); //elppa
		s = "apple";
		System.out.println(new StringBuilder(s).reverse().toString()); // elppa
		
		
		
		
	}// end of main
}// end of class
