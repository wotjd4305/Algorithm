import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

public class swe6781 {
	static Scanner sc = new Scanner(System.in);
	static String[] arr_nums;
	static String[] arr_cols;
	static Stack<Integer> ST = new Stack<>();

//      static PriorityQueue<Integer> R_st =
//    		  new PriorityQueue<>();
//      static PriorityQueue<Integer> G_st =
//    		  new PriorityQueue<>();
//      static PriorityQueue<Integer> B_st =
//    		  new PriorityQueue<>();
//      
	static ArrayList<Integer> R_AL = new ArrayList<Integer>();
	static ArrayList<Integer> G_AL = new ArrayList<Integer>();
	static ArrayList<Integer> B_AL = new ArrayList<Integer>();

	public static void main(String[] args) {

		String answer;
		int T = sc.nextInt();

		// testcase
		for (int t = 0; t < T; t++) {
			answer = "Continue";

			R_AL.clear();
			G_AL.clear();
			B_AL.clear();

			// true is win

			if (solution())
				answer = "Win";

			System.out.println("#" + (t + 1) + " " + answer);
		}
	}

	public static boolean solution() {
		boolean result = false;
		int R_count = 0;
		int G_count = 0;
		int B_count = 0;
		int idx = 0;
		Make_Arr();

		// 갯수 세고, Queue에 넣기
		for (String str : arr_cols) {
			if (str.equals("R")) {
				R_AL.add(Integer.parseInt(arr_nums[idx++]));
				R_count++;
			}
			if (str.equals("G")) {
				G_AL.add(Integer.parseInt(arr_nums[idx++]));
				G_count++;
			}
			if (str.equals("B")) {
				B_AL.add(Integer.parseInt(arr_nums[idx++]));
				B_count++;
			}
		}

		// 1)R G B 갯수가 3의 배수가 아니면
		if (!(R_count % 3 == 0 && G_count % 3 == 0 && B_count % 3 == 0))
			return result;

		// 2)오름차순 정렬
		Collections.sort(R_AL);
		Collections.sort(G_AL);
		Collections.sort(B_AL);
		
	
		// 3)
		boolean R_visited[] = new boolean[R_count];
		boolean G_visited[] = new boolean[G_count];
		boolean B_visited[] = new boolean[B_count];

		// 4)
		int btn = 0;
		for(int i =0; i<(R_count-2); i++)
		{
			int buffer = R_AL.get(i);
			
				
			int cnt=0;
			for(int j =i+1; j<R_count; j++)
			{
				if(buffer == R_AL.get(j) ||
						R_visited[j] == true)
					continue;
				
				if((buffer+1) == R_AL.get(j))
				{
					System.out.println(buffer+"-"+R_AL.get(j));
					R_visited[j] = true;
					cnt++;
					buffer++;
				}
				else
					continue;
				
				if(cnt == 3)
					{
						btn++;
						R_visited[i] = true;
						break;
					}
			}
			
		}
		System.out.println(btn);
		
		
		// 5)

		

		// System.out.println();

		// 5)결론 내기. 전부다 true여야 true 표출
		if (Make_Des(R_count, R_visited) && Make_Des(G_count, G_visited) && Make_Des(B_count, B_visited))
			result = true;

		return result;
	}

	

	public static void Make_Arr() {
		String buffer_nums = sc.next();
		String buffer_cols = sc.next();
		arr_nums = buffer_nums.split("");
		arr_cols = buffer_cols.split("");

	}

	public static boolean Make_Des(int count, boolean[] arr_visited) {

		for(int i =0; i<count; i++)
			System.out.print(" " + arr_visited[i]);
		System.out.println();
		
		for (int i = 0; i < count; i++) {			
			if (!arr_visited[i])
				return false;
		}

		return true;
	}

}