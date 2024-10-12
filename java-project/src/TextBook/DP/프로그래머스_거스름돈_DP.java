package TextBook.DP;

// https://school.programmers.co.kr/learn/courses/30/lessons/12907

public class 프로그래머스_거스름돈_DP {

    public int solution(int n, int[] money) {
        int[][] dp = new int[money.length + 1][n + 1];

        for (int i = 0; i < money.length + 1; i++) {
            dp[i][0] = 1;
        }

        // 규칙찾기 dp[i-1][j] + dp[i][j-money[i-1]
        for (int i = 1; i < money.length + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (j < money[i - 1])
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - money[i - 1]]) % 1000000007;
            }
        }
        return dp[money.length][n];
    }

}
