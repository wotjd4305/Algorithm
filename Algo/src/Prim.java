package Algo.src;

import java.util.Arrays;
import java.util.Scanner;

//입력값
/*
7 11
0 1 2
0 2 2
0 5 8
1 2 1
1 3 19
2 5 5
3 4 7
3 5 11
3 6 15
4 5 9
4 6 3
 */

public class Prim {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        int[][] adj = new int[V][V];
        //간선정보받기
        for(int i =0; i<E; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            adj[a][b] = c;
            adj[b][a] = c;
        }
        //true 는 내편
        boolean[] check = new boolean[V];
        //key는 거리, p는 부모
        int[] key = new int[V];
        int[] p = new int[V];
        Arrays.fill(key, Integer.MAX_VALUE);

        //아무거나 선택, 0부터하자
        p[0] = -1;
        key[0] = 0;
        //이미하나 골랐으니 v-1개를 골라야함
        for(int i = 0; i<V-1; i++){
            int min = Integer.MAX_VALUE;
            int idx = -1;

            //안골라진 친구중 key가 가장 작은 친구.
            for(int j = 0; j<V; j++){
                if(!check[j] && key[j] < min){
                    idx = j;
                    min = key[j];
                }
            }//for j

            //idx : 선택 안된 애들 중, key가 젤 작은 친구.
            check[idx] = true;
            //idx정점에서 출발하는 모든 간선에 대해서 key를 업데이트
            for(int j =0; j<V; j++){
                //check가 안되있으며, 간선이 존재하며, 그 간선이 key값보다 작다면 업데이트!
                if (!check[j] && adj[idx][j] != 0 && key[j] > adj[idx][j]){
                        p[j] = idx;
                        key[j] = adj[idx][j];
                }
            }
        }

        int result = 0;
        for(int i =0; i<V;i++) result += key[i];
        System.out.println(result);
        System.out.println(Arrays.toString(p));



    }
}
