package main.java;

public class proCity {


    static int MOD = 20170805;
    static int answer = 0;
    public static int solution(int m, int n, int[][] cityMap)
    {   //0 2 0 0 0 2
        //0 0 2 0 1 0
        //1 0 0 2 2 0  -> 2

        //1 ! 1 1 1 !
        //1 1 ! ! 0 0
        //0 1 2 ! ! 2  -> 2
        int Arr[][] = new int[m][n];
        answer = 0;

        answer = makeArr(Arr, cityMap, m, n);

        answer %= MOD;
        return answer;
    }

    public static int makeArr(int Arr[][], int cityMap[][], int m, int n)
    {
        //첫시작 1로 초기화
        Arr[0][0] = 1;

        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(i ==0 && j == 0)
                    continue;
                if(cityMap[i][j] == 1)
                {
                    Arr[i][j] = 0;
                    continue;
                }

                    Arr[i][j] += estimate(Arr,cityMap,i, j);

            }
        }
        PrintArr(Arr,m,n);

        return Arr[m-1][n-1];
    }

    public static void PrintArr(int Arr[][], int m , int n)
    {
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                System.out.print(Arr[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static int estimate(int Arr[][], int cityMap[][], int i, int j)
    {
        int upBuffer = i-1;
        int leftBuffer = j-1;
        int total =0;

        if(cityMap[i][j] == 0)
        {
            //왼쪽
            while(leftBuffer != -1)
            {
                if(cityMap[i][leftBuffer] != 2)
                    break;
                leftBuffer--;
            }


            //위쪽
            while(upBuffer != -1 )
            {
                if(cityMap[upBuffer][j] != 2)
                    break;
                upBuffer--;
            }

        }
        if(cityMap[i][j] == 2)
            return 0;

        if(upBuffer != -1)
            total += Arr[upBuffer][j];
        if(leftBuffer != -1)
            total += Arr[i][leftBuffer];
        return total;
    }

    public static void main(String[] args) {

        int m = 3;
        int n = 6;

        int[][] cityMap ={
                {0,2,0,0,0,2},
                {0,0,2,0,1,0},
                {1,0,0,2,2,0}
        };/*
        int[][] cityMap ={
                {0,0,0},
                {0,0,0},
                {0,0,0}
        };*/


        System.out.println(solution(m, n,cityMap));


    }



}
 
 
