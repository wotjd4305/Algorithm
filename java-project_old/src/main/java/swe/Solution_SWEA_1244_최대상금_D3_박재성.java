package swe;

import java.util.*;

public class Solution_SWEA_1244_최대상금_D3_박재성 {
	static Scanner sc = new Scanner(System.in);
	static String answer = "";
	static int max = 0;
	static int possibleMax = 0;
	static int exN;
	static int arr[];
	static int arr_count[];

	public static void main(String[] args) {
		int t = sc.nextInt();

		for (int T = 1; T <= t; T++) {
			String str = sc.next();
			exN = sc.nextInt();
			answer = "";
			max = 0;
			arr = new int[10];
			arr_count = new int[10];
			possibleMax = findMax(str);

			dfs(str);
			answer = "" + max;

			System.out.println("#" + T + " " + answer);
		}
	}

	// 길이/2이면 충분...
	public static void dfs(String str) {
		String pmax_s = "" + possibleMax ;

		int idx = 0;
		for(int n = 0; n<exN; n++) {
			int max = 0;
			int tmp_idx = -1; // 최대값을 가진 녀석.
			for (int i = idx; i < str.length(); i++) {
				if(str.charAt(i) >= max ){
					max = str.charAt(i);
					tmp_idx = i;
				}
			}
			//최대값이 이미 앞에있네?
			if(idx == tmp_idx) {
				idx++;
				n--;
			}//아니라면
			else{
				swap(str, idx, tmp_idx);
				idx++;
			}

			//최대값과 같고 홀수개면 마지막 두글자 바꿔줌
			if(pmax_s.equals(str) && (exN % 2 == 1)){
				swap(str, str.length()-1, str.length()-2);
				break;
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
			arr[Integer.parseInt("" + str.charAt(i))]++;
		}
		Collections.sort(a, Collections.reverseOrder());

		for (int i : a)
			buffer += i + "";

		return Integer.parseInt(buffer);
	}
	
}
