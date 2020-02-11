import java.util.Scanner;

public class swe1210 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        //초기화
        int answer = 0;
        int arr[][];
        int row = 0;
        int col = 0;

        //왼 오 위 순으로 탐색
        int[] dx = {-1, 1, 0};
        int[] dy = {0, 0, -1};


        for (int t = 0; t < 10; t++) {
            //처음값 삭제.
            sc.nextInt();

            int N = 101;
            answer = 0;
            row = N - 1;
            arr = new int[N][N];

            for (int i = 1; i <= 100; i++)
                for (int j = 1; j <= 100; j++)
                    arr[i][j] = sc.nextInt();

            for (int i = 1; i <= 100; i++) {
                if (arr[100][i] == 2) {
                    col = i;
                    break;
                }
            }

            //방향이 처음엔 없으니 0 - 왼 1 - 오  2 - 위
            int btn = 2;

            while (true) {
                for (int i = 0; i < 3; i++) {
                    //오른쪽으로 가는중이였다면? 왼쪽으로가는 중이였다면?
                    if (btn == 1 && i == 0)
                        i=1;
                    else if (btn == 0 && i == 1)
                        i=2;

                    if ((((col + dx[i] >= 1) && (col + dx[i] < N)) &&
                            ((row + dy[i] >= 1) && (row + dy[i] < N))) &&
                            (arr[row + dy[i]][col + dx[i]] == 1)) {
                        row += dy[i];
                        col += dx[i];
                        btn = i;

                        break;
                    }
                }
                //마지막줄이면
                if (row == 1) {
                    break;
                }
            }
            answer = col;
            System.out.println("#" + (t + 1) + " " + (answer-1));
        }
    }
}