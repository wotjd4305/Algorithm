package Algo.src;

import java.util.Arrays;
import java.util.Scanner;

/** �������� */
public class Z03_순열 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String args[]) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == j)
					continue;// ���� ����� �ݺ����� ���������� �Ѿ
				// for(int k = 0; k<3; k++) {
				// if(i==k || j==k) continue;
				System.out.println(i + "," + j + "," + (3 - i - j));
				// }
			}
		}

		

		// System.out.println(Arrays.toString(box));
	}// end of main

}// end of class
