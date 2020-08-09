package 자료구조;

import java.util.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class 위상정렬 {
    static int n;
    static int e;

    public static void main(String args[]){
        n=7;
        e=9;
        List<List<Integer>> array = new ArrayList<List<Integer>>();

        for(int i=0; i<n+1; i++){
            array.add(new ArrayList<Integer>());
        }

        // 간선 목록 v1 -> v2
        int[] src = {1, 1, 2, 4, 3, 3, 5, 2, 5}; //9개
        int[] dsc = {2, 3, 5, 6, 4, 7, 6, 4, 4};
        int[] degree = new int[n+1];

        for(int i=0; i<e; i++){
            array.get(src[i]).add(dsc[i]);
            degree[dsc[i]]++;
        }

        topolSort(array,degree);
    }

    static void topolSort( List<List<Integer>> array , int degree[]){
        Queue<Integer> q = new LinkedList<Integer>();
        Queue<Integer> result = new LinkedList<Integer>();

        for(int i=1; i<n+1; i++){
            if(degree[i] == 0)
                q.offer(i);
        }

        while(!q.isEmpty()){
            int node = q.poll();
            result.offer(node);

            for(int i : array.get(node)){
                degree[i]--;

                if(degree[i]==0) q.offer(i);

            }

        }

        System.out.println(result);

    }
}
