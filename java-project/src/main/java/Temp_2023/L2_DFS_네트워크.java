package Temp_2023;

import java.util.LinkedList;
import java.util.Queue;

public class L2_DFS_네트워크 {

    static boolean[] visited;
    static int answer = 0;

    public static void main(String args[]) {
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        System.out.println(solution(n, computers));
    }

    public static int solution(int n, int[][] computers) {
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                DFS(i, n, computers);
                answer++;
            }
        }
        return answer;
    }

    public static void DFS(int start, int depth, int[][] computer) {
        for (int j = 0; j < depth; j++) {
            if(computer[start][j] == 1 && !visited[j]){
                visited[j] = true;
                DFS(j, depth, computer);
            }
        }
    }
}
