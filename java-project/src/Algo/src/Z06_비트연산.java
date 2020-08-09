package Algo.src;

import java.util.Arrays;
import java.util.Scanner;



public class Z06_비트연산{

	static Scanner sc = new Scanner(System.in);

	public static void main(String args[]) {
		int a  = 123;
		System.out.println(a);
		
		a= 0x110111; // 16진수 0x or 0x
		a= 011011;	//8진수 0
		a= 0b110111; //2진수 0B OR 0b
		System.out.println(a); //55
		System.out.println(Integer.toBinaryString(a)); //110111
		System.out.println(Integer.toString(a, 3)); //3진수
		
		int b = 0b1100; //12
		int c= 0b1001; //9
		System.out.println(Integer.toBinaryString(b));//1100
		System.out.println(Integer.toBinaryString(c));//1001
		System.out.println(Integer.toBinaryString(b & c) + " = b&c");//1000
		
		System.out.println(Integer.toBinaryString(1));//1
		System.out.println(Integer.toBinaryString(1<<0)+ " = 1<<0");//1
		System.out.println(Integer.toBinaryString(1<<1)+ " = 1<<1");//10
		System.out.println(Integer.toBinaryString(1<<2)+ " = 1<<2");//100
		
		
		//��Ʈ����ŷ : ���ϴ� ��Ʈ�� ���� �̾Ƴ���
		System.out.println("-------노가다-------");
		int n = 0b10011011;
		System.out.println((n & 0b1) == 0? 0:1);//1
		System.out.println((n & 0b10) == 0? 0:1);//1
		System.out.println((n & 0b100) == 0? 0:1);//0
		System.out.println((n & 0b1000) == 0? 0:1);//1
		System.out.println((n & 0b10000) == 0? 0:1);//1
		System.out.println((n & 0b100000) == 0? 0:1);//0
		System.out.println((n & 0b1000000) == 0? 0:1);//0
		System.out.println((n & 0b10000000) == 0? 0:1);//1
		System.out.println((n & 0b100000000) == 0? 0:1);//-

		System.out.println("for문을 이용");
		for(int i =8; i>=0; i--)
		{
			System.out.print((n & (1<<i)) == 0? 0:1);
		}
		
		
		int[] z = {-7,-3,-2,5,8};
		
		//32비트 2의 5승
		for(int i =0; i<(1<<5); i++)
		{
			if((i & 0b1) != 0) System.out.print(z[0]+",");//���� ���� �ڸ��� 1�� �ڸ��� ��Ʈ����ŷ����
			if((i & 0b10) != 0) System.out.print(z[1]+",");//2���ڸ��� ����ŷ����
			if((i & 0b100) != 0) System.out.print(z[2]+",");//2���ڸ��� ����ŷ����
			if((i & 0b1000) != 0) System.out.print(z[3]+",");//2���ڸ��� ����ŷ����
			if((i & 0b10000) != 0) System.out.print(z[4]+",");//2���ڸ��� ����ŷ����
			System.out.println();
		}
		
		
		
	}// end of main
}// end of class
