import java.util.Scanner;

public class swe1209 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {


        int arr[][] = new int[100][100];
        int answer= 0;
        int sum = 0;

        for (int testcase = 0; testcase < 10; testcase++) {
            int T = sc.nextInt();
            answer = 0;

            //입력과 초기화
            for(int i =0; i<100; i++) {
                for(int j = 0; j<100; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            //행
            for(int i =0; i<100; i++) {
                sum = 0;
                for(int j =0; j<100; j++) {
                    sum += arr[i][j];
                }
                answer = Math.max(answer, sum);
            }

            //열
            for(int i=0; i<100; i++) {
                sum = 0;
                for(int j =0; j<100; j++) {
                    sum += arr[j][i];
                }
                answer = Math.max(answer, sum);
            }

            //좌상 - 우하 대각선
            sum =0;
            for(int i =0; i<100; i++) {
                sum +=arr[i][i];
            }
            answer = Math.max(answer, sum);

            //우상 - 좌하 대각선
            sum =0;
            for(int i =0; i<100; i++) {
                sum +=arr[i][99-i];
            }
            answer = Math.max(answer, sum);

            System.out.println("#" + (testcase+1) + " " +answer);

        }
    }

}
