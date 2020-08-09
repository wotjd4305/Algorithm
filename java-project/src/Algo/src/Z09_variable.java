package Algo.src;

import java.util.Arrays;
import java.util.Scanner;



//변수의 종류는 3가지
public class Z09_variable {
	//전역변수는 메소드 밖에만 있으면 됨!
	int b; // 전역변수 초기값이 들어간다. - (인스턴스변수)
	static int c; // 전역변수 초기값이 들어간다. - (스태틱변수)
	
//	각타입의 초기값
//	정수 : 0
//	실수 : 0.0
//	문자 : '\u0000', 문자로 '0'값
//	논리 : false
//	참조형 : null

	static Scanner sc = new Scanner(System.in);

	public static void main(String args[]) {
		int d; // 지역변수 - 메소드 안쪽, 초기값이 들어가지 않는다.

	}// end of main

	public static void a() {

	}

}// end of class
