package Temp_2023;

import java.util.*;

public class L3_그래프_가장먼노드 {

    public static void main(String[] args) {
        int n = 6;
        int[][] vertex = {{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}};
        System.out.println(solution(n, vertex));
    }

    public static long solution(int n, int[][] vertex) {
        boolean visited[] = new boolean[n+1];
        boolean link[][] = new boolean[n+1][n+1];
        int count[] = new int[n+1];
        Queue<Integer> que = new LinkedList<>();

        for(int i = 1; i<=n; i++){
            count[i] = 1;
        }

        for(int[] i : vertex){
            link[i[0]][i[1]] = true;
            link[i[1]][i[0]] = true;
        }

        que.add(1);
        while(!que.isEmpty()){
            int start = que.poll();
            visited[start]= true;
            for(int i=1; i<=n; i++){
                if(!visited[i] && link[start][i]){
                    if(i==start) continue;
                    visited[i] = true;
                    count[i] += count[start];
                    que.add(i);
                }
            }
        }

        for(int i=1 ; i<=n; i++){
            System.out.println(count[i]);
        }

        int max = Arrays.stream(count).max().getAsInt();
        long maxCount = Arrays.stream(count)
                .filter(t -> t == max)
                .count();


        return maxCount;
    }
}
