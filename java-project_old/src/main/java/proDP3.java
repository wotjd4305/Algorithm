public class proDP3 {


    static  int[][] dp;
    public static void main(String[] args) {


        int[][] puddles = {{2,2} , {1,2}, {2,1}, {4,4}};
        int m = 6;
        int n = 5;


        System.out.println(solution(m,n,puddles));
        //showArray(triangle);
    }

    public static int solution(int m, int n, int[][] puddles) {
        int answer = 0;

        //이중배열 전체 초기화, 값은 1, 물웅덩이 여부는 false로
        //1,1부터 시작하니까 보기 편하게
        dp = new int[m+1][n + 1];
        dp[1][1] =1;

        //물웅덩이값, 넣어주기
        for (int i = 0; i < puddles.length; i++) {
            dp[puddles[i][0]][puddles[i][1]] = -1;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(dp[i][j] == -1) {
                    dp[i][j] = 0;

                    continue;
                }
                if(i!=1)    dp[i][j]+=dp[i-1][j]%1000000007;
                if(j!=1)    dp[i][j]+=dp[i][j-1]%1000000007;
            }
        }
        showArr(m,n,dp);
        answer = dp[m][n]% 1000000007;
        return answer;
    }

    public static void showArr(int m, int n,int[][] arr)
    {
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }


}



