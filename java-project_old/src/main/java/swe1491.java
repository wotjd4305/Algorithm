import java.util.Scanner;

public class swe1491 {
    static Scanner sc  = new Scanner(System.in);
    static long answer = 0;

    public static void main(String[] args) {

        //A X lR – Cl + B X (N - R X C)
        //N(1*1)개의 타일을 이용해 R*C의 직사각형
        //1,N-1  2,(N-2)2/2   3,(N-3)/3  ~ N-1,1
        //정사각형이 가능한
        //N은 1~10만이니 10만개의 경우의 수
        int t = sc.nextInt();
        for(int T=1; T<=t; T++) {
            long N = sc.nextInt();
            long A = sc.nextInt();
            long B = sc.nextInt();
            answer = Long.MAX_VALUE;
            answer = solution(N,A,B);

            System.out.println("#" + T + " " + answer);
        }
    }
    //A X lR – Cl + B X (N - R X C)
    public static long solution(long N, long A, long B)
    {
        for(int R=1; R<N; R++)
        {
            for(int C=1; C<N; C++)
            {
                if(R*C > N)
                    break;
                answer = Math.min(answer, A*Math.abs(R-C) + B*(N-R*C) );

            }
        }



        return answer;
    }


}