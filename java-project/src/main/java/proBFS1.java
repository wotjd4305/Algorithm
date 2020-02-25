package main.java;/*
import java.util.*;

public class proBFS1 {

    static Queue<Graph> GraphList = new LinkedList<Graph>();
   static boolean value[];
    static int word_length;
    static int min = 999999;



    public static void main(String[] args) {

        String begin = "hit";
        String target = "cog";
        String[] words = {"hot","dot" ,"dog","lot","log","cog"};

        //6길이면 0,1,2,3,4,5,6 0까지포함하여 7개
        value = new boolean[words.length+1];

        solution(begin, target, words);


    }


    public static void BFS(int[][] Arr, boolean[] c ,int count)
    {

        Queue<Integer> q = new LinkedList<Integer>();
        q.add(GraphList.peek().dst);
        value[src+1] = true;


        while(!q.isEmpty())
        {
            src = q.peek().dst;

            for(int i= ; i<=n; i++)
            {

            }
        }
    }



    public static int solution(String begin, String target, String[] words) {

        word_length = target.length();
        makeGraph(begin, words);
        makeArray(words.length);

        for(Graph g : GraphList)
        {
            System.out.println(g.src + " - " + g.dst);
        }

        */
/*BFS(-1 , value, 0);
*//*

        return 0;

    }




    public static void makeGraph(String begin, String[] words)
    {
        //첫번째 시작부터
        for(int i=0; i<words.length; i++)
        {
            int word_count =0;

            for(int k=0; k<word_length; k++)
            {
                if(words[i].charAt(k) == begin.charAt(k))
                    word_count++;

                //하나만 차이나면!
                if(k==word_length-1 && word_count == word_length-1)
                    GraphList.add(new Graph(-1,i));

            }

        }

        //나머지
        for(int i=0; i<words.length; i++)
        {
            for(int j=i; j<words.length; j++)
            {
                int word_count = 0;
                //같으면 지나감
                if(i==j)
                    continue;
                //한개차이가 나는가?
                for(int k=0; k<word_length; k++)
                {
                    if(words[i].charAt(k) == words[j].charAt(k))
                        word_count++;

                    //하나만 차이나면!
                    if(k==word_length-1 && word_count == word_length-1) {
                        GraphList.add(new Graph(i, j));
                    }
                }

            }

        }

    }


    public static int[][] makeArray(int length)
    {
        int[][] Array = new int[length+1][length+1];

        for(Graph g : GraphList)
        {
            //0-1 | 1-2 | 1-4 | 2-3 | 2-4|순
            Array[g.src+1][g.dst+1] = 1;
        }




        return Array;
    }

}


//그래프
class Graph {
    int src;
    int dst;
    Boolean value = false;

    //생성자
    public Graph(int src, int dst) {
        this.src = src;
        this.dst = dst;
    }

    public void setValue(Boolean v) {
        value = v;
    }
}*/
