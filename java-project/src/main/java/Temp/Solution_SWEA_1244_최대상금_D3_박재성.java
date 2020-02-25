package main.java.Temp;

import java.util.*;

public class Solution_SWEA_1244_최대상금_D3_박재성 {
	static Scanner sc = new Scanner(System.in);
	static String answer = "";
	static int max = 0;
	static int possibleMax = 0;
	static int exN;

	public static void main(String[] args) {
		int t = sc.nextInt();

		for (int T = 1; T <= t; T++) {
			String str = sc.next();
			exN = sc.nextInt();
			answer = "";
			max = 0;
			possibleMax = findMax(str);

			dfs(str);
			answer = "" + max;

			System.out.println("#" + T + " " + answer);
		}
	}

	// 길이/2이면 충분...
	public static void dfs(String str) {
		String pmax_s = "" + possibleMax ;
		
		while (true) {

			for (int i = 0; i < pmax_s.length();) {
				
				
				//큰 값이 얼마나 중복되느냐 확인
				int idx = i;
				int count = 1;		
				while(true) {
					//마지막이면
					if(idx+1 == pmax_s.length()) {
						i +=count;
						break;
					}
					if(pmax_s.charAt(idx) == pmax_s.charAt(idx+1)) {
						count++;
						idx++;
					}
					else {
						i +=count;
						break;
					}
				}
							
				
				
				//count만큼 
				int count2 = 1;
				ArrayList<Integer> AL = new ArrayList<>();
				
				//최대값을 가지는 인덱스 AL로..
				for (int j = str.length()-1; j >= 2; j--) {
					if(count2 == count)
						break;
					if(pmax_s.charAt(i) == str.charAt(j)) {
						count2++;
						AL.add(j);
					}		
				}
						
			}
		
		}
	}

	
	public static String swap(String str, int p1, int p2) {
		String buffer = "";
		for (int i = 0; i < str.length(); i++) {
			// 안바뀌는 부분은 냅두고
			if (i == p1) {
				buffer += str.charAt(p2);
				continue;
			}
			if (i == p2) {
				buffer += str.charAt(p1);
				continue;
			}
			buffer += str.charAt(i);

		}
		return buffer;
	}

	
	public static int findMax(String str) {
		ArrayList<Integer> a = new ArrayList<>();
		String buffer = "";
		for (int i = 0; i < str.length(); i++) {
			a.add(Integer.parseInt("" + str.charAt(i)));
		}
		Collections.sort(a, Collections.reverseOrder());

		for (int i : a)
			buffer += i + "";

		return Integer.parseInt(buffer);
	}
	
}
