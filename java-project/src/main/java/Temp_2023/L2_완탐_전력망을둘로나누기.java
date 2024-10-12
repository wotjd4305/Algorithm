package Temp_2023;

import java.util.*;

public class L2_완탐_전력망을둘로나누기 {

    public static void main(String args[]) {
        int wires[][] = {{1, 2}, {2, 7}, {3, 7}, {3, 4}, {4, 5}, {6, 7}};
        int n = 7;

        System.out.println(solution(n, wires));
    }


    public static int solution(int n, int[][] wires) {
        boolean isLinked[][] = new boolean[n+1][n+1];
        boolean isVisited[][] = new boolean[n+1][n+1];

        Queue<Integer> que1 = new LinkedList<>();
        Queue<Integer> que2 = new LinkedList<>();

        for (int i = 0; i < wires.length; i++) {
            int a = wires[i][0];
            int b = wires[i][1];
            isLinked[a][b] = true;
            isLinked[b][a] = true;
        }

        int result = Integer.MAX_VALUE;

        for (int i = 0; i < wires.length; i++) {
            que1.clear();
            que2.clear();

            int a = wires[i][0];
            int b = wires[i][1];
            isLinked[a][b] = false;
            isLinked[b][a] = false;

            int aSize = 0;
            int bSize = 0;

            // 영역 1
            isVisited = new boolean[n+1][n+1];
            que1.add(a);
            while (!que1.isEmpty()) {
                int start = que1.poll();
                for (int j = 1; j <= n; j++) {
                    if(start == j) continue;
                    if(isLinked[start][j] && !isVisited[start][j]) {
                        que1.add(j);
                        isVisited[start][j] = true;
                        isVisited[j][start] = true;
                        aSize++;
                    }
                }
            }



            // 영역 2
            isVisited = new boolean[n+1][n+1];
            que2.add(b);
            while (!que2.isEmpty()) {
                int start = que2.poll();
                for (int j = 1; j <= n; j++) {
                    if(start == j) continue;
                    if(isLinked[start][j] && !isVisited[start][j]) {
                        que2.add(j);
                        isVisited[start][j] = true;
                        isVisited[j][start] = true;
                        bSize++;
                    }
                }
            }

            isLinked[a][b] = true;
            isLinked[b][a] = true;

            System.out.println(i + "번쨰" + aSize + "," + bSize);
            result = Math.min(result, Math.abs(aSize - bSize));
        }

        return result;
    }
}
