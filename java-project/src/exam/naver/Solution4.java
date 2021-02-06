package exam.naver;

import java.io.IOException;

public class Solution4 {

/*
    static int N = 2;
    static int inputCapacity = 5;
    static int inputFiles[] = {1,2,3,4,5};
*/

/*
    static int N = 1;
    static int inputCapacity = 5;
    static int inputFiles[] = {1,4,5};
*/

    static int N = 2;
    static int inputCapacity = 3;
    static int inputFiles[] = {2,2,2,2,2};

    ////////////////////////


    static int answer;
    static boolean isVisited[];

    public static void main(String[] args) throws IOException {
        System.out.println(solution(N, inputCapacity, inputFiles));
    }

    public static int solution(int n, int capacity, int[] files) {

        isVisited = new boolean[files.length];
        answer = 0;

        for(int i =0; i<files.length; i++){
            isVisited[i] = true;
            dfs(1,i, 0, 0, files,capacity, n);
            isVisited[i] = false;
        }

        return answer;
    }

    public static void dfs(int hardNum, int idx,int total ,int totalSum, int files[], int capacity, int N) {

        if(hardNum == N+1) {
            answer = Math.max(answer, totalSum);
            return;
        }

        //만약 선넘었네?
        if(total + files[idx] > capacity){
            dfs(hardNum+1, idx, 0, totalSum, files,capacity,N);
        }
        else{//선 안넘었네?
            for(int i =0; i<files.length; i++) {
                if(!isVisited[i]) {//방문 안해야
                    isVisited[i] = true;
                    dfs(hardNum, i, total + files[idx], totalSum + 1, files,capacity,N);
                    isVisited[i] = false;
                }
            }
        }

    }

}