package TextBook;

import java.util.Arrays;

//반복문
public class Z34_조합2 {
	
	public static int arr[] = {1,3,5,7,9};
	public static int trr[];
	
	public static void main(String args[]) {
		int n = arr.length;
		int r = 3;
		trr = new int[r];
		comb(n,r);
	}
	
	public static void comb(int n, int r) {
		if(r==0) { // 종료 파트
			System.out.println(Arrays.toString(trr));
		}
		else if(n<r) {
			return;
		}
		else //재귀 파트
		{
			trr[r-1] = arr[n-1];
			comb(n-1, r-1);
			comb(n-1, r);
		}
	}

}
