package main.java.Temp2021_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bac_톱니바퀴_G5 {


    //북 북동 동 동남 남 남서 서 서북
    static int dx[] = {-1,-1,0,1,1,1,0,-1};
    static int dy[] = {0,1,1,1,0,-1,-1,-1};

    static int tempArr[];

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Top topArr[];
    static int order[][];

    static int orderN ;

    public static void main(String args[]) throws IOException {

        topArr = new Top[5];
        topArr[0] = new Top(new LinkedList<>());

        for(int i=1; i<=4; i++){
            st = new StringTokenizer(br.readLine());
            LinkedList<Integer> d = new LinkedList<>();
            String dummy = st.nextToken();
            for(int j=0; j<8; j++){
                 d.add(Integer.parseInt(dummy.charAt(j) + ""));
            }
            topArr[i] = new Top(d);
        }

        st = new StringTokenizer(br.readLine());
        orderN = Integer.parseInt(st.nextToken());

        order = new int[orderN+1][2];

        for(int i=1; i<=orderN; i++){
            st = new StringTokenizer(br.readLine());
            order[i][0] = Integer.parseInt(st.nextToken());
            order[i][1] = Integer.parseInt(st.nextToken());
        }


        LinkedList<Integer> test = new LinkedList<>();

        for(int i=1; i<=orderN; i++){
            System.out.print(order[i][0]);
            System.out.println(order[i][1]);
        }

        for(Top t : topArr) {
            System.out.println(t.toString());
        }

        solution();

        int answer =0;

        for(Top t : topArr) {
            System.out.println(t.toString());
        }
        for(int i=1; i<=4; i++){
            System.out.println(topArr[i].getDir().get(0));
            answer += topArr[i].getDir().get(0) * Math.pow(2,i-1);
        }
        System.out.println(answer);
    }

    public static void solution(){



        // 회전 횟수 만큼 돌릴
        // N - 0, S - 1
        // 1 시계, -1 반시계
        // 0 - 북, 2 - 동, 4 - 남, 6 - 서
        for(int orderIdx=1; orderIdx<=orderN; orderIdx++){


            int target = order[orderIdx][0];
            int dir = order[orderIdx][1];

            int tempDir[] = new int[9];

            //채우기
            for(int i=1; i<=4; i++){
                tempDir[(i*2)-1] = topArr[i].getDir().get(6);
                tempDir[(i*2)] = topArr[i].getDir().get(2);
            }


            // 본인
            if(isRange(target)){
                // 반시계
                if(dir == -1) {
                    int temp = topArr[target].getDir().get(0);
                    topArr[target].getDir().pollFirst();
                    topArr[target].getDir().addLast(temp);
                }
                // 시계
                if(dir == 1){
                    int temp = topArr[target].getDir().get(7);
                    topArr[target].getDir().pollLast();
                    topArr[target].getDir().addFirst(temp);
                }
            }

            // 회전 횟수 만큼 돌릴
            // N - 0, S - 1
            // 1 시계, -1 반시계
            // 0 - 북, 2 - 동, 4 - 남, 6 - 서
            // 1 2   3 4   5 6   7 8

            //오른쪽
            for(int i=1; i<=3; i++){


                if(isRange(target+i)){
//                    int a = topArr[target+i-1].getDir().get(2); // 오른쪽
//                    int b = topArr[target+i].getDir().get(6); // 왼쪽
                    int a = tempDir[2*(target+i-1)]; //2 4 6 8
                    int b = tempDir[2*(target+i) -1]; // 1 3 5 7


                    if(a==b) {
                        break;
                    }
                    //같은 방향
                    if(i%2 == 0){


                        // 반시계
                        if(dir == -1) {
                            int temp = topArr[target+i].getDir().get(0);
                            topArr[target+i].getDir().pollFirst();
                            topArr[target+i].getDir().addLast(temp);
                        }
                        // 시계
                        if(dir == 1){
                            int temp = topArr[target+i].getDir().get(7);
                            topArr[target+i].getDir().pollLast();
                            topArr[target+i].getDir().addFirst(temp);
                        }

                    }
                    //다른 방향
                    else{
                        // 반시계
                        if(dir == -1) {
                            int temp = topArr[target+i].getDir().get(7);
                            topArr[target+i].getDir().pollLast();
                            topArr[target+i].getDir().addFirst(temp);
                        }
                        // 시계
                        if(dir == 1){
                            int temp = topArr[target+i].getDir().get(0);
                            topArr[target+i].getDir().pollFirst();
                            topArr[target+i].getDir().addLast(temp);
                        }

                    }
                }
            }


            // 1 2   3 4   5 6   7 8
            // 왼쪽
            for(int i=1; i<=3; i++){
                if(isRange(target-i)){
                    int a = tempDir[2*(target-i+1) -1]; // 왼쪽 1 3 5 7
                    int b = tempDir[2*(target-i)]; // 오른쪽 2 4 6 8

                    if(a==b) {
                        break;
                    }

                    //같은 방향
                    if(i%2 == 0){
                        // 반시계
                        if(dir == -1) {
                            int temp = topArr[target-i].getDir().get(0);
                            topArr[target-i].getDir().pollFirst();
                            topArr[target-i].getDir().addLast(temp);
                        }
                        // 시계
                        if(dir == 1){
                            int temp = topArr[target-i].getDir().get(7);
                            topArr[target-i].getDir().pollLast();
                            topArr[target-i].getDir().addFirst(temp);
                        }
                    }
                    //다른 방향
                    else{
                        // 반시계
                        if(dir == -1) {
                            int temp = topArr[target-i].getDir().get(7);
                            topArr[target-i].getDir().pollLast();
                            topArr[target-i].getDir().addFirst(temp);

                        }
                        // 시계
                        if(dir == 1){
                            int temp = topArr[target-i].getDir().get(0);
                            topArr[target-i].getDir().pollFirst();
                            topArr[target-i].getDir().addLast(temp);
                        }
                        }
                    }
                }
            }
        }


    public static boolean isRange(int i){
        boolean result = false;
        if(i>=1 && i<=4)
            result = true;
        return  result;
    }

    public static class Top{
        LinkedList<Integer> dir;

        @Override
        public String toString() {
            return "Top{" +
                    "dir=" + dir.toString() +
                    '}';
        }

        public Top(LinkedList<Integer> dir) {
            this.dir = dir;
        }

        public LinkedList<Integer> getDir() {
            return dir;
        }

        public void setDir(LinkedList<Integer> dir) {
            this.dir = dir;
        }
    }
}
