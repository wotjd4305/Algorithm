package Algo.src.WorkShop;
import java.util.Arrays;
import java.util.Scanner;

class SWEA_Solution_2007_패턴마디의길이_D2_박재성 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		// 초기화
		int answer = 0;
		String buffer = "";

		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

			// 초기화
			answer = 0;
			buffer = "";

			// 입력
			String str = sc.next();

			//교수님이 짠 코드
			//마디의 최대 길이는 10!
			int i;
			for(i =1; i<=10; i++) {// 0 <= < i
				String sub1 = str.substring(0,i);
				String sub2 = str.substring(i,i*2);
				if(sub1.equals(sub2)) {
					break;
				}				
			}
			System.out.println("#" + test_case + " " + i);
			
			
			
			
			
			
			
			
//내가 짠 코드		
/*
			for (int i = 0; i < str.length(); i++) {
				if (str.substring(i, i + buffer.length()).equals(buffer))
					if (i != 0)
						break;
				buffer += str.charAt(i) + "";
			}
			answer = buffer.length();
*/
			
		}
	}
}