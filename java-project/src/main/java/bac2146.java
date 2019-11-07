import java.util.*;

public class bac2146 {
    static int N;
    static boolean visit[][];
    static Queue<Graph> q = new LinkedList<>();
    static int[][] Array;
    static int[][] Map;
    static int idxNumber = 1;
    static int currentNumber = 1;
    static int answer = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean visit_copy[][] = new boolean[N][N];

 
        //입력
        N = sc.nextInt();
        Array = new int[N][N];
        visit = new boolean[N][N];
        Map = new int[N][N];



        //답
        int min = 99999999;


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Map[i][j] = 0;
            }
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Array[i][j] = sc.nextInt();
            }
            sc.nextLine();
        }

        //1)섬 번호주며, visit 초기화
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (Array[i][j] != 0 && visit[i][j] == false) {

                    GiveNumberToiland(i, j);
                    idxNumber++;
                }
            }
        }

        //복사
        System.arraycopy(visit_copy,  0, visit, 0 , visit_copy.length);

        //2)Queue에 넣기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                currentNumber = Array[i][j];
                if( currentNumber != Array[i][j] && !visit[i][j])
                {
                    int temp = 0;
                    q.add(new Graph(i,j));
                    temp = bfs();
                    min = Math.min(temp, min);

                    //다시 돌리기 위해서 복사
                    System.arraycopy(visit,  0, visit_copy, 0 , visit.length);

                }

                q.clear();
            }
        }

        System.out.println(min);



    /*
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(Array[i][j]);
            }
            System.out.println();
        }*/
/*
        q.add(new Graph(now, 0));
        visit[now] = true;
        int ans = bfs();

        System.out.println(ans == 0 ? "use the stairs" : ans);
 */
    }


    private static void GiveNumberToiland(int x, int y) {


        visit[x][y] = true;
        Array[x][y] = idxNumber;
        //동 서 남 북
        if (!(x + 1 >= N) && visit[x + 1][y] == false && Array[x + 1][y] == 1)
            GiveNumberToiland(x + 1, y);
        if (!(x - 1 <= 0) && visit[x - 1][y] == false && Array[x - 1][y] == 1)
            GiveNumberToiland(x - 1, y);
        if (!(y - 1 <= 0) && visit[x][y - 1] == false && Array[x][y - 1] == 1)
            GiveNumberToiland(x, y - 1);
        if (!(y + 1 >= N) && visit[x][y + 1] == false && Array[x][y + 1] == 1)
            GiveNumberToiland(x, y + 1);
    }


    private static class Graph {
        int x, y;

        Graph(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }



    private static int bfs() {
        int ans = 0;

        while (!q.isEmpty()) {
            Graph now = q.poll();

            if ( currentNumber != 0 && currentNumber != Array[now.x][now.y] ) {
                return ans;
            }
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if ( (nx < N && nx >= 0) &&
                        (ny < N && ny >= 0) &&
                             !visit[nx][ny] &&
                                Array[nx][ny] != currentNumber)
                {
                    q.add(new Graph(nx, ny));
                    visit[nx][ny] = true;
                }
            }
            ans++;
        }

        return ans;
    }

}

