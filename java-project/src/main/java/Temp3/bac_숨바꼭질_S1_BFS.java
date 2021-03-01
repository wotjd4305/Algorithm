package main.java.Temp3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bac_숨바꼭질_S1_BFS {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] array;

    static int N;
    static int K;

    public static void main(String args[]) throws IOException {
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        array = new int[100002];

        Arrays.fill(array, Integer.MAX_VALUE);

        solution();

        int count = 0;
//        for(int i : array){
//            System.out.println( "array[" + (count++) + "] = " + i);
//        }
        System.out.println(array[K]);
    }

    public static void solution(){
        int curN = N;
        int count = 1;
        Queue<Integer> qu = new LinkedList<>();

        qu.add(curN);
        qu.add(-1);
        array[curN] = 0;

        while(!(qu.size() <= 1)){
            int newN = 0;

            if(qu.peek() == -1){
                qu.poll();
                if(qu.peek() == -1) break;
                newN = qu.poll();
                count++;
                qu.add(-1);
            }
            else newN = qu.poll();


            //
            for(int i =1; i<=3; i++){

                // -1, +1, *2
                switch (i){
                    case 1:
                        if(isRange(newN-1) && array[newN-1] > count) {
                            qu.add(newN - 1);
                            array[newN-1] = count;
                            //System.out.println("[-1]index= " + (newN-1) + ", " + count);
                        }
                        break;
                    case 2:
                        if(isRange(newN+1) && array[newN+1] > count) {
                            qu.add(newN + 1);
                            array[newN+1] = count;
                            //System.out.println("[+1]index= " + (newN+1) + ", " + count);
                        }
                        break;
                    case 3:
                        if(isRange(newN*2) && array[newN*2] > count) {
                            qu.add(newN * 2);
                            array[newN*2] = count;
                            //System.out.println("[*2]index= " + (newN*2) + ", " + count);
                        }
                        break;
                    default:
                        break;
                }
            }

        }

    }

    public static boolean isRange(int v){
        boolean result = false;
        if(v >= 0 && v <=(100001)){
            result = true;
        }
        return result;
    }
}
