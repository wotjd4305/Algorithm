package TextBook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

//반복문
public class Z35_Solution_SWEA2_백트래킹_완탐 {

	static int max;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static HashSet<String> set;
	
	public static void main(String args[]) throws NumberFormatException, IOException {

		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String s = st.nextToken();
			int[] num = new int[s.length()];
			for(int i =0; i<s.length(); i++) {
				num[i] = Integer.parseInt(s.charAt(i) + "");
			}
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			set = new HashSet<>();//같은 상태의 중복을 제거
			max = 0;
			find(num,N);
			System.out.println("#" + t + " " + max);
			
		}

	}

	private static void find(int[] num, int N) {
		//num배열은 10진수 숫자로 만들기
		int val = 0;
		for(int i=0; i<num.length; i++) {
			val = val *10 + num[i];
		}
		
		if(set.contains(""+val+N)) {
			return;
		}
		set.add(""+val+N);
		
		if(N==0) { // 종료파트, 교환 회수가 0이면 종료
			if(max < val)
				max = val;
		}else { // 임의의 2개 숫자를 골라서(조합) 교환
			for(int i = 0; i<num.length-1; i++) {
				for(int j =i+1; j<num.length; j++) {
					int temp = num[i];
					num[i] = num[j];
					num[j] = temp;
					find(num, N-1);
					temp = num[i];
					num[i] = num[j];
					num[j] = temp;
					
					
				}
			}
		}
		
	}

}
