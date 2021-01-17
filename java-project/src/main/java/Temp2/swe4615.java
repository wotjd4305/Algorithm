package main.java.Temp2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class swe4615 {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Integer> AL;
    static int Arr[][];
    //오른쪽 위쪽 왼쪽 아래쪽 1시 11시 7시 5시
    static int dx[] = {1, 0,-1,0    ,1,-1,-1,1};
    static int dy[] = {0, -1,0,1    ,-1,-1,1,1};
    static int N;

    public static void main(String[] args) {
        int T = sc.nextInt();
        ArrayList<Integer> answer;

        for(int t=0; t<T; t++) {
            //N - 보드길이, M - 돌을 놓는 횟수
                 N = sc.nextInt();
                int M = sc.nextInt();

                //초기화
                //N=8 {3,3 | 3,4 | 4,3 | 4,4 }
                //N=6 {2,2 | 2,3 | 3,2 | 3,3 }
                //N=4 [1,1 | 1,2 | 2,1 | 2,2 }
                Arr = new int[N][N];
                AL = new ArrayList<>();
                init_Arr(N);


                answer = Solution(N,M);

                System.out.println("#" + (t + 1) + " " + answer.get(0) + " " + answer.get(1));
            }
        }

        public static void init_Arr(int N)
        {
                    Arr[N/2][N/2] = 2; //4,4
                    Arr[N/2][N/2-1] = 1; //4,3
                    Arr[N/2-1][N/2] = 1; //3,4
                    Arr[N/2-1][N/2-1] = 2; //3,3
        }

        public static void PPrint(){
            for(int i=0; i<N; i++)
            {
                for (int j = 0; j < N; j++)
                {
                    System.out.print(Arr[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();

        }

        public static ArrayList<Integer> Print_BW_count(){
            int B_count =0;
            int W_count =0;
            for(int i=0; i<N; i++)
            {
                for (int j = 0; j < N; j++)
                {
                    //검
                    if(Arr[i][j] == 1)
                        B_count++;
                    if(Arr[i][j] == 2)
                        W_count++;
                }
            }
            ArrayList<Integer> AL = new ArrayList<>();
            AL.add(B_count);
            AL.add(W_count);

            return AL;
        }

        public static void put_the_stone(int x, int y, int color)
        {
            //배열이 작음
            //놓고 시작해야지!
            x = x-1;
            y = y-1;
            Arr[x][y] = color;

            //System.out.println("-----put------");
            //8방향이니까
            for(int i=0; i<8; i++)
            {

                int nx = x + dx[i];
                int ny = y + dy[i];
                Boolean chk = false;
                //System.out.println(nx + " " + ny);

                while((nx >= 0 && ny >=0) &&
                        (nx < N && ny <N) &&
                        (Arr[nx][ny] != 0))
                {
                    //같으면 종료
                    //다르면??
                    if(Arr[nx][ny] == color)
                    {
                        chk = true;
                        break;
                    }
                    nx += dx[i];
                    ny += dy[i];

                }

                while(chk)
                {
                    if(nx == x && ny == y)
                    {
                        break;
                    }

                    Arr[nx][ny] = color;
                    nx -= dx[i];
                    ny -= dy[i];
                }
            }
        }

        //가로, 세로, 11시 대각선, 1시 대각선
        //분기하는 함수 정의?
        public static ArrayList<Integer> Solution(int N, int M)
        {
            ArrayList<Integer> answer = new ArrayList<>();

            for(int i=0; i<M; i++)
            {
                //System.out.println("Try - " + i );
                int location_x = sc.nextInt();
                int location_y = sc.nextInt();
                int location_color = sc.nextInt();// 1 - 검정, 2 - 흰색
                put_the_stone(location_x,location_y,location_color);
                PPrint();

            }

            answer = Print_BW_count();
            return answer;
        }
}

