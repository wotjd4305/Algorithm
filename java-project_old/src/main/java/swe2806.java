import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class swe2806 {
    static Scanner sc  = new Scanner(System.in);
    static int answer=0;
    static int col[];
    static  int N;

    public static void main(String[] args) {


        int t = sc.nextInt();
        //N개의 퀸이 N*N배열
        for(int T=1; T<=t; T++) {
            answer = 0;
            N = sc.nextInt();
            //같은 행에 하나만 가지고있으면되니까
            col = new int[N+1];

            //솔루션, dfs
            solution();


            System.out.println("#" + T + " " + answer);
        }
    }

    public static int solution()
    {
        //0행 i열
        for(int i=1; i<=N; i++) {

            col[1] = i;
            dfs(col, 1);
        }
        return answer;
    }

    //여러 선택지중 한 행에 놓았으면, 다음 행에 놓고를 반복
    public static void dfs(int col[], int row)
    {
        //다 놓았으면 끝냄
        if(row == N)
            answer++;
        else {
            //놓일수잇는가? 다돌려보자
            for (int i = 1; i <= N; i++) {
                //가능하면 다음 행
                col[row+1] = i;
                if (isPossible(col, row + 1)) {
                    dfs(col, row + 1);
                }
            }
        }
    }

    public static Boolean isPossible(int Arr[], int row)
    {
        for(int i=1; i < row; i++) {
            // 같으면
            if(Arr[i] == Arr[row])
                return false;

            //대각선
            if(Math.abs(i - row) == Math.abs(Arr[i] - Arr[row]))
                return false;

        }

       return true;
    }
}
