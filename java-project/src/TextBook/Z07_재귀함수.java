package TextBook;

import java.util.Scanner;

public class Z07_재귀함수 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String args[]) {

		// 0 1 2 3
		for (int i = 0; i < 4; i++) {
			System.out.print(i + " ");
		}
		System.out.println();

		// 0 1 2 3
		a(0); // 시작값을 보냄, 0 1 2 3
		System.out.println();

		
		
		// 3 2 1
		for (int i = 3; i > 0; i--) {
			System.out.print(i + " ");
		}
		System.out.println();

		// 3 2 1
		b(3);
		System.out.println();

		
		
		// 2 4 6 8
		for(int i =2; i<=8; i+=2) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		// 2 4 6 8
		c(2);
		System.out.println();
		
		
		
		//3 5 7 9
		for(int i =3; i<10; i+=2) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		//3 5 7 9
		d(3,2,10);//초기값, 증감값, 조건기준값
		System.out.println();
		
		//10 7 4 1
		for(int i =10; i>0; i-=3) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		//10 7 4 1
		e(10,3,0); // 초기값, 감소값, 조건기준값
		System.out.println();

	}// end of main

	// 리턴타임입 메서드명(매개변수)
	static void a(int i) {

		if (i >= 4) {// basis case 종료파트 - 조건식

		} else {
			System.out.print(i + " ");// 반복할 실행문
			a(i + 1); // 증감식
		}
	}

	static void b(int i) {

		if (i == 0) {

		} else {
			System.out.print(i + " ");
			b(i - 1);
		}

	}

	static void c(int i) {
		if (i == 10) {

		} else {
			System.out.print(i + " ");
			c(i + 2);
		}
	}
	

	// 3 5 7 9 - (초기값, 증감값, 기준값)
	static void d(int init, int plus, int last) {
		if (init > last) { // basis case 종료파트 - 조건식
				
		} else {
			System.out.print(init + " "); // 반복할 실행문
			d(init + plus, plus, last); // 증감식
		}
	}
	
	// 3 5 7 9 - (초기값, 감소값, 기준값)
	static void e(int init, int minus, int last) {
		if (init < last) { // basis case 종료파트 - 조건식
				
		} else {
			System.out.print(init + " "); // 반복할 실행문
			e(init - minus, minus, last); // 증감식
		}
	}
	
	
	

}// end of class
