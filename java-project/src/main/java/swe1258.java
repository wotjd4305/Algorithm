package main.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class swe1258 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int answer;
    static int N;
    static int arr[][];
    static boolean arr_b[][];
    static ArrayList<Point> AL;

    static int dx[] = { 0, 0, 0, -1, 1 };
    static int dy[] = { 0, -1, 1, 0, 0 };

    public static void main(String[] args) throws NumberFormatException, IOException {

        int T = Integer.parseInt(br.readLine());

        for (int testcase = 0; testcase < T; testcase++) {
            N = Integer.parseInt(br.readLine());
            input();
            solution();

            Collections.sort(AL);
            System.out.print("#" + (testcase +1 ) + " " + AL.size()
            );
            for (Point p : AL)
                System.out.print(" " + p.x_l + " " + p.y_l);
            System.out.println();

        }
    }

    public static void solution() {

        int flag = 0;

        AL.clear();

        for (int i = 0; i < N; i++) {
            flag = 0;
            int y_l = 0;
            int x_l = 0;
            int k = 0;



            //1)
            for (int j = 0; j < N; j++) {

                if (arr_b[i][j])
                    continue;

                // 0이아닌 시작점 정함
                if (arr[i][j] != 0 && flag == 0) {
                    //System.out.println(j);
                    k = j;
                    flag = 1;
                }

                // 밖으로 나가거나 0이나오면 길이를 구함
                if ((arr[i][j] == 0 && flag == 1) || (j == N - 1 && flag == 1)) {
                    y_l = j - k+1;
                    if(arr[i][j] == 0)
                        y_l--;
                    //System.out.println(y_l + "y - leng");
                    break;
                }
            }//for




            // k는 가로축의 시작점.
            if (flag == 1) {
                for (int m = i; m < N; m++) {
                    if (arr[m][k] == 0 || m == N - 1) {
                        x_l = m - i+1;
                        if(arr[m][k] == 0)
                            x_l--;
                        //System.out.println(x_l + "x - leng");
                        break;
                    }
                }

                for (int m = i; m < i+x_l; m++) {
                    for (int n = k; n < k+y_l; n++) {
                        //System.out.print(" B" +m +"-" +n);
                        arr_b[m][n] = true;
                        flag = 0;

                    }
                    //System.out.println();
                }
                AL.add(new Point(x_l, y_l));
                i--;
            }



        }//for

    }

    public static void input() throws IOException {

        // 초기화
        arr = new int[N][N];
        arr_b = new boolean[N][N];
        AL = new ArrayList<>();

        // 입력
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int temp = Integer.parseInt(st.nextToken());
                arr[i][j] = temp;

            }
        }
    }

    public static class Point implements Comparable<Point> {
        int x_l;
        int y_l;
        int gop;


        Point(int x_l, int y_l) {
            this.x_l = x_l;
            this.y_l = y_l;
            this.gop = x_l * y_l;
        }

        @Override
        public int compareTo(Point o) {

            if (this.gop > o.gop)
                return 1;
            else if (this.gop == o.gop)
                if(this.x_l > o.x_l)
                    return 1;
                else
                    return-1;
            else
                return -1;

        }

    }

}
