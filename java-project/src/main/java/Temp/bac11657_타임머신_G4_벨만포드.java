package main.java.Temp;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class bac11657_타임머신_G4_벨만포드 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static int N;
	static int M;
	static ArrayList<Point> Arr;
	static int D[]; // 그정점까지의 최소거리

	static final int max = 1000000000;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Set<Point> Hs = new HashSet();
		D = new int[N+1];

		//배열 입력
		for(int i =0; i<M; i++){
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				int src = Integer.parseInt(st.nextToken());
				int dsc = Integer.parseInt(st.nextToken());
				int time = Integer.parseInt(st.nextToken());
				Hs.add(new Point(src,dsc,time));
			}
		}

		//중복제거후 리스트에 넣기
		Arr = new ArrayList(Hs);


		//정점 1부터 시작할것
		for(int i=2; i<=N; i++) D[i] = max;
		D[1] = 0;

		//N-1번 돌아야함, 마지막 번쨰는 음의싸이클 판단
		//그 이후로도 갱신시, 음의사이클
		for(int i=1; i<=(N-1); i++){
			for(int j=0; j<Arr.size(); j++){
				if(D[Arr.get(j).src] >= max) continue;
				if(D[Arr.get(j).dsc] > D[Arr.get(j).src] + Arr.get(j).time)
					D[Arr.get(j).dsc] = D[Arr.get(j).src] + Arr.get(j).time;
			}
		}

		boolean isCycle = false;
		for(int j=0; j<Arr.size(); j++){
			if(D[Arr.get(j).src] >= max ) continue;
			if(D[Arr.get(j).dsc] > D[Arr.get(j).src] + Arr.get(j).time)
				isCycle = true; // 더갱신됬으니.. 싸이클
		}

		//음이면
		//sb.append("");
		if (isCycle) {
			sb.append(-1);
		} else {
			for (int i = 2; i <= N; i++) {
				sb.append(D[i] == max ? -1 + "\n" : D[i] + "\n");
			}
		}

		System.out.print(sb);

	}

	public static class Point{
		int src;
		int dsc;
		int time;
		public Point(int src, int dsc, int time){
			this.src = src;
			this.dsc = dsc;
			this.time = time;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			Point point = (Point) o;
			return src == point.src &&
					dsc == point.dsc &&
					time == point.time;
		}

		@Override
		public int hashCode() {
			return (src+","+dsc+","+ time).hashCode();
		}
	}

}
