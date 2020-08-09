package Algo.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//반복문
public class Z35_Solution_SWEA_그리디 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String args[]) throws NumberFormatException, IOException {
/*
		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();

			Integer[] num = new Integer[s.length()];
			for (int i = 0; i < s.length(); i++) {
				num[i] = s.charAt(i) - '0';
			}
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			//[4]동일한 숫자를 교환했는지 체크하기 위한 ArrayList 배열
			ArrayList<Integer>[] check = new ArrayList[10];
			for(int i = 0; i<check.length; i++) {
				check[i] = new ArrayList<Integer>();
			}
			
			

			for (int i = 0; i < num.length && N > 0; i++) {
				int maxIndex = i;
				for (int j = i; j < num.length; j++) {
					if (num[maxIndex] <= num[j]) {// 최대숫자가 여러개일때
						maxIndex = j;
					}
				}
				if (num[maxIndex] != num[i]) { // 312 1 => 321, 최대 숫자가 MSB위치 숫자와 다를떄 교환

					int temp = num[maxIndex];
					num[maxIndex] = num[i];
					num[i] = temp;
					N--;
				}
			}
			
			//교환횟수가 남았으면 남은만큼 교환.
			//짝수만큼 남은건 무시, 홀수만큼 남으면 1회 교환(LSB) -> 321 4
			if(N % 2 == 1) {
				int temp = num[num.length-1];
				num[num.length-1] = num[num.length-2];
				num[num.length-2] = temp;
			}

			System.out.print("#" + t + " ");
			for (int i = 0; i < num.length; i++) {
				System.out.print(num[i]);
			}
			
			
			//[4] 동일한 숫자를 교환 했는지 체크하기 위해 기록후, 같은 수를 2개이상 바궜을떄
			//교환회수의 감소없이 내림차순 정렬을 해줌.
			//교환후 최대숫자의 값 : temp, 최대숫자가 있었던 자리 : maxIndex
			ArrayList<Integer>alNum = check[temp];
			if(alNum.size() > 1) //동일한 숫자를 2개이상 바꾼경우
			{
				Collections.sort(alNum);
				for(int j = 0; j<alNum.size(); j++) {
					int maxI = alNum.get(j);
					for(int k = j; k<alNum.size(); k++) {
						if(num[maxI] < num[alNum.get(k)]) {
							maxI = alNum.get(k);
						}
					}
					
					//num[maxI] <-> num[alNum.get(j)] 교환
					int tempN = num[alNum.get(j)];
					num[alNum.get(j)] = maxI;
					maxI = tempN;
					
				}
			}
			
			//777770 같은경우는 0과7을 바꾸기보단 77 동일한 숫자바꾸는게 맞음.
			//Set을통한 중복판별.
			//배열 -> 리스트, 객체의 배열만 된다.
			HashSet<Integer> hs = new HashSet<Integer>(Arrays.asList(num));
			if(N%2 == 1&& hs.size() == num.length) {
				int temp = num[num.length-1];
				num[num.length-1] = num[num.length-2];
				num[num.length-2] = temp;
			}
			
		}*/

	}

}
