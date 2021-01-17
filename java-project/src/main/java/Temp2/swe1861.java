package main.java.Temp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swe1861{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int answer;
    static int answer_count;
    static int arr[][];
    static int arrt[][];

    static ArrayList<Integer> AL;

    static int dx[] = { 0, 0, 0, -1, 1 };
    static int dy[] = { 0, -1, 1, 0, 0 };

    public static void main(String[] args) throws NumberFormatException, IOException {

        int T = Integer.parseInt(br.readLine());

        for (int testcase = 0; testcase < T; testcase++) {
            init();
            solution();

            Pair result_P = result();
            answer = result_P.x;
            answer_count = result_P.y;

            System.out.println("#" + (testcase + 1) + " " + (answer) + " " + (answer_count+1));
        }
    }

    public static Pair result()
    {
        AL = new ArrayList<>();
        int max = 0;
        int max_idx = 0;

        for(int i=1; i<=N; i++) {
            for(int j =1; j<=N; j++) {
                if(max <= arrt[i][j])
                    max = arrt[i][j];
            }
        }

        for(int i=1; i<=N; i++) {
            for(int j =1; j<=N; j++) {
                if(max == arrt[i][j])
                    AL.add(arr[i][j]);
            }
        }

        Collections.sort(AL);
        max_idx = AL.get(0);

        return new Pair(max_idx, max);
    }

    // 처음에 출발해야하는 방 번호와, 최대 몇개의 방을 이동할수있는지
    // 이동할수있는 방의개수가 최대인 방이 중첩되면 그 중 가장 작은 수.
    public static void solution() {

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (arrt[i][j] != 0)
                    continue;
                BFS(i, j);

            }
        }
    }

    public static void BFS(int i, int j) {

        int idx = 1;
        int new_x;
        int new_y;
        Pair tp;

        Queue<Pair> Qu = new LinkedList<>();
        Qu.add(new Pair(i, j));

        while (!Qu.isEmpty()) {
            tp = Qu.poll();

            for (int k = 1; k <= 4; k++) {
                new_x = tp.x + dy[k];
                new_y = tp.y + dx[k];
                if (new_x >= 1 && new_x <= N && new_y >= 1 && new_y <= N) {

                    if (arr[tp.x][tp.y] == arr[new_x][new_y] + 1) {
                        Qu.add(new Pair(new_x, new_y));
                        arrt[new_x][new_y] = idx++;
                        break;
                    }
                }
            }
        }

    }

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1][N + 1];
        arrt = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}

class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
