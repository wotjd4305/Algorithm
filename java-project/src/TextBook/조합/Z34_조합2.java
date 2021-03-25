package TextBook.조합;

import java.lang.reflect.Array;
import java.util.Arrays;

//반복문
public class Z34_조합2 {
	
	public static int arr[] = {1,3,5,7,9};
	public static int trr[];

	static int n = arr.length;
	static int r = 3;
	
	public static void main(String args[]) {
		trr = new int[r];
		//comb(n,r);
		comp(0,0);
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

	public static void comp(int cnt, int cur){
		if(cnt == r){
			System.out.println(Arrays.toString(trr));
			return;
		}else{
			for(int i=cur; i<n; i++){
				trr[cnt] = arr[i];
				comp(cnt+1, i+1);
			}

		}
	}


}
