package main.java;

public class proDFS2 {
    static boolean value[][];
    static int answer =0;

    public static void main(String[] args) {

        int n = 3;
       int computers[][] = {{1,1,0}, {1,1,0}, {0,0,1}};

        System.out.println(solution(n, computers));


    }

    public static int solution(int n, int[][] computers) {
        value = new boolean[n][n];

        for(int i=0; i<n; i++)
        {
            if(!value[i][i])
            {
                DFS(i,n,computers);
                answer++;
            }
        }

        return answer;
    }

    //n=3
    public static void DFS(int start, int depth, int[][] computers)
    {
        for(int i= 0; i< depth; i++)
        {
            if(computers[start][i] == 1 && !value[start][i])
            {
                value[i][start] = true;
                value[start][i] = true;
                DFS(i,depth,computers);
            }
        }
    }


    }



