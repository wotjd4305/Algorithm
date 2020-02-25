package main.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swe1494 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static Pair[] arr;
    static boolean[] visited;
    static int N;
    static long answer;
    static Pair[] arr_s;
    static Pair[] arr_ns;



    public static void main(String[] args) throws NumberFormatException, IOException {

        int T = Integer.parseInt(br.readLine());

        for (int testcase = 0; testcase < T; testcase++) {
            answer = Long.MAX_VALUE;
            N = Integer.parseInt(br.readLine());
            solution();

            System.out.println("#" + (testcase + 1) + " " + (answer));
        }
    }

    public static void solution() throws IOException {
        arr = new Pair[N];
        visited = new boolean[N];
        arr_s = new Pair[N/2];
        arr_ns = new Pair[N/2];

        // 입력
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i] = new Pair(x, y);
        }

        //조합주고 돌리자!
        calcul(0, 0);
    }

    public static void calcul(int s, int idx) {

        // 범위 넘어나니까 끝내
        if (s == N) {
            return;
        }

        // 짝 다 채웠으니 끝냄.
        if (idx == N / 2) {
            answer = Math.min(answer, result());
            return;
        }

        //받고 버리고
        visited[s] = true;
        calcul(s+1, idx+1);
        visited[s] = false;
        calcul(s+1, idx);

    }

    public static long result() {
        int idx1 = 0;
        int idx2 = 0;
        // 선택되지 않은 애들에 한에서 배열 생성
        for (int i = 0; i < N; i++) {
            if (visited[i])
                arr_s[idx1++] = arr[i];
            else
                arr_ns[idx2++] = arr[i];
        }
        long sel_total_x = 0;
        long sel_total_y = 0;
        long not_sel_total_x = 0;
        long not_sel_total_y = 0;

        for (Pair p : arr_s) {
            sel_total_x += p.x;
            sel_total_y += p.y;
        }

        for (Pair p : arr_ns) {
            not_sel_total_x += p.x;
            not_sel_total_y += p.y;
        }

        long result_total_x = sel_total_x - not_sel_total_x;
        long result_total_y = sel_total_y - not_sel_total_y;

        long result = (result_total_x * result_total_x) + (result_total_y * result_total_y);

        return Math.abs(result);

    }


    public static class Pair {
        int x;
        int y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

}