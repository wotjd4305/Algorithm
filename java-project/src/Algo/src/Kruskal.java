package Algo.src;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Kruskal {
    static int[] parents;
    static int[] rank;
    //입력 첫줄은 정점의 갯수와 간선의 갯수
    //그 다음줄부터 간선의 정보가 정점1 정점2 간선의 갯수만큼 들어옴

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        int[][] edges = new int[E][3];
        for(int i =0; i<E; i++){
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
            edges[i][2] = sc.nextInt();
        }

        //간선들의 오름차순
        Arrays.sort(edges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //o1[2] o2[2]
                return Integer.compare(o1[2], o2[2]);
            }
        });

        //각 정점에 대해 유니언파인드 연산 준비
        for(int i =0; i<V; i++)
            makeSet(i);
        int cnt=0;
        int result=0;

        //정점의 개수-1 번 반복
        for(int i =0; i<E; i++){
            int a = findSet(edges[i][0]);
            int b = findSet(edges[i][0]);
            if(a==b)
                continue;
            union(a,b);
            result += edges[i][2];

            cnt++;
            if(cnt == V-1)
                break;
        }
        System.out.println(result);
        //같은팀이아 아니면 합쳐주고 간선 선택
        //같은팀이면 패스
    }
    static void makeSet(int x){
        parents[x] = x;
    }
    static int findSet(int x){
        if(x==parents[x]){
            return x;
        }else
        {
            parents[x] = findSet(parents[x]);
            return parents[x];
        }
    }

    static void union(int x, int y){
        int px = findSet(x);
        int py = findSet(y);
        if(rank[px] > rank[py]){
            parents[py] = px;
        }else{
            parents[px] = py;
            if(rank[px] == rank[py]){
                rank[py]++;
            }
        }

    }
}
