package main.java.Temp;

import java.util.*;

public class Solution_SWEA_1266_소수완제품확률_D6_박재성 {
	static Scanner sc = new Scanner(System.in);

	static int T;
	static double skillA;
	static double skillB;
	
	static double answer = 0;
	static double A[] = new double[19];
	static double B[] = new double[19];
	
	//[N][R]
	static double COMB[][] = new double[19][19];
	static int prime[] = {2,3,5,7,9,11,13,17};
	
			

	public static void main(String args[]) {
		T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			skillA = sc.nextDouble()/100.0f;
			skillB = sc.nextDouble()/100.0f;
			solution();
			
			System.out.println(answer);
		}
		
	}
	
	

	public static void solution() {
		
		
		makeComb();
		
		//
		double Atotal = 0;
		double Btotal = 0;
		for(int idx : prime) {
			A[idx] = Math.pow(skillA, idx) * Math.pow((1-skillA), 18-idx);
			B[idx] = Math.pow(skillB, idx) * Math.pow((1-skillB), 18-idx);			
			Atotal += A[idx] * COMB[18][idx];
			Btotal += B[idx] * COMB[18][idx];
		}
		
		double bothNotPrime_p = (1-Atotal) * (1-Btotal);
		answer = 1 - bothNotPrime_p;
		
		
	}
	
	//외우자
	public static void makeComb() {
		// nCr = (n-1)C(r-1) + (n-1)Cr
		//COMB[2][1] = COMB[1][0] * COMB[1][1];
		//COMB[18][2], COMB[18][3], COMB[18][5]... COMB[18][17]; 
		for(int i =1; i<=18; i++) {
			COMB[i][0] = 1;
			COMB[i][1] = 1;
		}
		for(int i= 2; i<=18; i++) {
			for(int j=1; j<=i; j++) {
				COMB[i][j] = COMB[i-1][j-1] + COMB[i-1][j];
			}
		}
	}
	
	
}
