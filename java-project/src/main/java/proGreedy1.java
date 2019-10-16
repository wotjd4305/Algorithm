import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class proGreedy1{


    static boolean possiable[];
    static boolean lostBoolean[];
    static boolean reserveBoolean[];
    static int answer = 0;

    public static void main(String[] args) {
        int n = 5;
        int[] lost = {2,4};
        int[] reserve = {1,3,5};

        System.out.println(solution(n,lost,reserve));
    }

    public static int solution(int n, int[] lost, int[] reserve)
    {
        possiable = new boolean[n+1];
        lostBoolean = new boolean[n+1];
        reserveBoolean = new boolean[n+1];

        setLost(lost);
        setReserve(reserve);
        setLostMinusReserve(n);

        findStudent(n);

        return answer;
    }

    public static void setLost(int lost[])
    {
        for(int i =0; i<lost.length; i++)
        {
            System.out.println("set Lost " + lost[i]);
            lostBoolean[lost[i]] = true;
        }
    }

    public static void setReserve(int reserve[])
    {
        for(int i =0; i<reserve.length; i++)
        {
            System.out.println("set Reserve " + reserve[i]);
            reserveBoolean[reserve[i]] = true;
        }
    }


    public static void setLostMinusReserve(int n)
    {
        for(int i =1; i<=n; i++)
        {
            //여분이있지만 털린애
            if(reserveBoolean[i] == true)
                if(lostBoolean[i] == true)
                {
                    reserveBoolean[i] = false;
                    lostBoolean[i] = false;
                    System.out.println("ssss"+i);
                }
        }
    }

    public static void findStudent(int n)
    {
        //가능성 셋팅
        for(int i=1; i<=n; i++)
        {
            if(lostBoolean[i] == false)
            {
                System.out.println("find" + i);
                possiable[i]= true;
            }
        }

        for(int i=1; i<=n; i++)
        {
            //잃어버린애고
            if(lostBoolean[i] == true)
                //범위를 넘지 않으며 뒤에 애가 여분이 있으면
                if((i+1 != n+1) && (reserveBoolean[i+1] == true))
                {
                    reserveBoolean[i+1] = false;
                    lostBoolean[i] = false;
                }

        }

        //lostBoolean이 true인(체육복을 가진)수 계산
        for(int i=1; i<=n; i++)
        {
            if(lostBoolean[i] == false)
            {
                System.out.println("last" + i);
                answer++;
            }
        }

    }


}