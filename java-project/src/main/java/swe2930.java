import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class swe2930 {
    static Scanner sc  = new Scanner(System.in);
    static int K;
    static int N;
    static String answer = "";
    static PriorityQueue<Integer>  PQ = new PriorityQueue<>(Collections.reverseOrder());

    public static void main(String[] args) {


        int t = sc.nextInt();
        //N개의 퀸이 N*N배열
        for(int T=1; T<=t; T++) {
            N = sc.nextInt();
            answer = "";
            PQ.clear();

            solution();
            System.out.println("#" + T  + answer);
        }
    }


    public static void solution()
    {
        for(int n=0; n<N; n++) {
            int operation = sc.nextInt();
            if( operation == 1) {
                PQ.add(sc.nextInt());
                continue;
            }
            if( PQ.isEmpty() ) {
                answer += " -1";
                continue;
            }
            answer += " " + PQ.poll();
        }
    }


}
