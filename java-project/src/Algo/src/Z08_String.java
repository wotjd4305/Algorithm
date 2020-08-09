package Algo.src;

import java.util.Arrays;
import java.util.Scanner;
/**
 * 
 * 문자열
 *
 */
public class Z08_String {
	static Scanner sc = new Scanner(System.in);
	public static void main(String args[]) {
		String s = "abcDefGHij"; //10개
		
		//replace, substring
		//서브스트링은 오버로딩을 이용한것. 매개변수의 다른 갯수
		p(s); // abcDefGHij
		p(s.replace("Def", "abababab") + " : 문자열을 변경"); // abcababababGHij : 문자열을 변경
		p(s.substring(7) + " : 문자열을 추출 7번쨰~끝"); // Hij : 문자열을 추출 7번쨰~끝
		p(s.substring(5,8) + " : 문자열을 추출 5번쨰~7번째"); // fGH : 문자열을 추출 5번쨰~7번째
		
		//split
		// ','로 구분하여 배열에 가공
		String str = "호랑이, 사자, 기린, 토끼, 다람쥐";
		String[] srr = str.split(","); // 정규화 표현식
		System.out.println(Arrays.toString(srr));
		
		//charAt
		String s2 = "abcdefg";
		for(int i =0; i<s2.length(); i++) {
			System.out.print
			(s2.charAt(i) + " ");
		}
		
		//return타입이 char[]타입
		//toCharArray는 배열을 하나더 만들어야해서 복사하는공간낭비
		//메모리 생성시간 + 메모리 복사시간 = 낭비
		//charAt()을 쓰자.
		char[] crr = s2.toCharArray();
		p(crr);
		System.out.println();
		
		
		
		//상수풀 사용 vs 객체생성
		//메모리의 효율적인 사용
		String s4 = new String("hi"); // String객체를 생성하는 FM 방법
		String s5 = new String("hi");
		String s6 = "hi";
		String s7 = "hi"; // 문자열만 기본형타입처럼 생성하는 것을 허용.
		System.out.println(s4 == s5); // false
		System.out.println(s6 == s7); // true, 둘은 상수 풀(class Area)에 있기 때문에. 같으면 재사용 하게되기 떄문에
		System.out.println(s4.equals(s5)); // true 내용물 비교
		System.out.println(s6.equals(s7)); // true 내용물 비교
		
		//replace를 통한 문자열 제거
		String s8 = "apple";
		System.out.println(s8.replace("pp", ""));
		System.out.println(s8);
		
		//역순으로 출력
		s8 = "hello";
		for(int i = s8.length()-1; i>=0; i--) {
			System.out.print(s8.charAt(i));
		}
		System.out.println();
		
	
		
		
		
	}// end of main
	public static void p(String str)
	{
		System.out.println(str);
	}
	
	public static void p(char ch)
	{
		System.out.println(ch);
	}
	
	public static void p(char[] ch)
	{
		for(char c: ch)
			System.out.print(c + " ");
	}
}// end of class
