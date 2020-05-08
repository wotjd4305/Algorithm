package main.java.test;


import java.util.Scanner;

public class b_0402_Algo2_서울_11반_박재성 {

    static int T; // 테스트케이스 수
    static int V; // 정점의 수
    static int E; // 간선의 수
    static String answer; // 정답

    static boolean Array[][]; // 연결여부
    static int visited[]; //방문여부 및 색깔

    //입력 스캐너 생성
    static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) {
        T = sc.nextInt();//T입력

        //테스트케이스 갯수 만큼 반복.
        for(int i =0; i<T; i++) {
            answer = "YES";//디폴트로 YES로 주고, DFS에서 이분그래프가 아닌것을 확인하면 NO로 변경.

            V = sc.nextInt();// 정점 입력
            E = sc.nextInt();// 간선 입력
            Array  = new boolean[V+1][V+1];//초기화 


            //처리부
            solution();

            //출력부
            System.out.println(answer);
        }
    }

    public static void solution() {

        //정점 연결
        for(int i = 0; i<E; i++) {
            int s = sc.nextInt();
            int d = sc.nextInt();
            Array[s][d] = true;
            Array[d][s] = true;

        }

        //0은 방문X, 1,2를 다른색으로 할것임.
        visited = new int[V+1];//1부터 시작이니


        //0은 방문 x
        for(int i =1; i<=V; i++ ) {
            for(int j=1; j<=V; j++) {
                if(i == j) continue; // 같은건 생략
                if(!Array[i][j]) continue; // 정점 연결안되면 다시
                {
                    visited[i] = 1; //1로 시작
                    dfs(i,j,1,0);//시작정점, 방문 안하면 dfs돌릴수 있음. 색은 1로시작
                }
            }
        }


    }

    public static void dfs(int s, int d, int color, int count) {

        //간선의 수만큼 돌렸으면 나가기
        if(count == E) {
            return;
        }

        //칼라 바꿔 주기 용
        int temp = 0;
        if(color == 1) temp =2;
        if(color == 2) temp =1;

        //방문안했으면
        if(visited[d] == 0)
            visited[d] = temp;
        else if(visited[d] == color) { //다음게
            answer = "NO";
            return;
        }
        else {

            for(int i =1; i<=V; i++) {
                if(i == d) continue; // 같은거 제외
                dfs(d,i, temp,count+1);
            }
        }
    }
}