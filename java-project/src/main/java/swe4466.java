import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class swe4466 {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Integer> AL;

    public static void main(String[] args) {
        int T = sc.nextInt();
        int answer = 0;

        for(int t=0; t<T; t++) {
                int N = sc.nextInt();
                int K = sc.nextInt();
                AL = new ArrayList<>();

                answer = Solution(N,K);

                System.out.println("#" + (t + 1) + " " + answer);
            }
        }

    public static int Solution(int N, int K)
    {
        int sum = 0;

        for(int i = 0; i<N; i++)
            AL.add(sc.nextInt());

        Collections.sort(AL, Collections.reverseOrder());

        for(int i =0; i<K; i++)
            sum += AL.get(i);


        return sum;
    }

}

