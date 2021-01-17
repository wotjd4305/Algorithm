package main.java.Temp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bac17143_낚시왕 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int R;
	static int C;
	static int M;
	static ArrayList<Shark> AL;
	static Shark[][] sh_arr;

	// 1 2 3 4 | 상 하 우 좌
	static int dx[] = {0, 0, 0, 1, -1};
	static int dy[] = {0, -1, 1, 0, 0};

	static int answer = 0;

	// 4 6 8 (R C M)
	// R C S D Z
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sh_arr = new Shark[R + 1][C + 1];
		AL = new ArrayList<>();
		answer = 0;
		input();
		solution();

		System.out.println(answer	);
	}

	public static void input() throws IOException {
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			AL.add(new Shark(r, c, s, d, z));
			sh_arr[r][c] = new Shark(r, c, s, d, z);
		}
	}


	//위
	public static void up_left(int i, int j, int m, int d, int z){
        //상 하 우 좌
        int new_row = i;
        int new_col = j;
        int new_d = d;

        int T = (d == 1) ? R : C;
        int id = (d == 1) ? i : j;

		if(m > id-1){
			if((m-(id-1)) > T-1){
				new_row = (2*T -1)- (m-(id-1));
			}
			else{
				new_row = m-(id-1)+1;

                if(d== 1)
                    new_d++;
                else
                    new_d--;
			}
		}
		else{
			new_row = id-m;
		}

        //둘 중 하나
        new_col = new_row;
        if( d==1)
            new_col = j;
        else
            new_row = i;
		if(isNotnullOrBig(sh_arr[new_row][new_col],z)){

			//Nothing
		}
		else {
			sh_arr[new_row][new_col] = new Shark(new_row, new_col, m, new_d, z);

		}
	}

	//왼
	public static void  right_down(int i, int j, int m, int d, int z){

	    //상 하 우 좌
		int new_row = i;
        int new_col = j;
		int new_d = d;

		int T = (d == 2) ? R : C;
		int id = (d == 2) ? i : j;

        if(m > T-id){
            if(m-(T-id) > (T-1)){
                new_row = (m-(T-id)) - (T-1) + 1;
            }
            else {
            	// 11 - (8 -(6-1));
				new_row = T - (m - (T-id));


				if(d== 2)
                    new_d--;
                else
                    new_d++;
            }
        }
        else{
            new_row = id+m;
        }

        //둘 중 하나
        new_col = new_row;
        if( d==2)
            new_col = j;
        else
            new_row = i;


		if(isNotnullOrBig(sh_arr[new_row][new_col],z)){
			//Nothing
		}
		else
			sh_arr[new_row][new_col] = new Shark(new_row, new_col, m, new_d, z);

    }


	public static boolean isNotnullOrBig(Shark s,int z){
		if(s == null)
			return false;
		if(s.z > z)
			return true;
		else
			return false;
	}



	public static void solution() {

		if(M==0)
			return;

		for(int t = 1; t <= C; t++) {

			//낚시왕이 낚음
			for(int i=1; i<=R; i++) {
				if (sh_arr[i][t] != null) {
					answer += sh_arr[i][t].z;
					AL.remove(sh_arr[i][t]);
					break;
				}
			}

			for(Shark[] s: sh_arr)
				Arrays.fill(s , null);

			for (Shark p : AL) {
				int move = 0;


				//상 하 우 좌
				if (p.d == 1 || p.d == 2 && p.s != 0)
					move = p.s % ((R- 1) * 2);
				if (p.d == 3 || p.d == 4 && p.s != 0)
					move = p.s % ((C - 1) * 2);

					switch (p.d) {
						case 1:
							up_left(p.r, p.c, move, p.d, p.z);
							break;
						case 2:
							right_down(p.r, p.c, move, p.d, p.z);
							break;
						case 3:
							right_down(p.r, p.c, move, p.d, p.z);
							break;
						case 4:
							up_left(p.r, p.c, move, p.d, p.z);
							break;
					}
			}

			//초기화
			AL.clear();

			for(int i = 1; i<=R; i++){
				for(int j = 1; j<=C; j++){
					if(sh_arr[i][j] != null) {
						AL.add(sh_arr[i][j]);
						//System.out.print(sh_arr[i][j].z + " ");
					}
						//System.out.print("0 ");
				}
				//System.out.println();
			}
			//System.out.println();


		}
	}

	static class Shark {
		int r;
		int c;
		int s;
		int d;
		int z;

		public Shark(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			Shark shark = (Shark) o;
			return r == shark.r &&
					c == shark.c &&
					s == shark.s &&
					d == shark.d &&
					z == shark.z;
		}

		@Override
		public int hashCode() {
			return ((r + "," + c + "," + s + "," + "," + d + "," + z)).hashCode();
		}

	}
}