import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class swe1493 {
    static Scanner sc  = new Scanner(System.in);
    static int answer = 0;

    static HashMap<vertex, Integer> HM;


    public static void main(String[] args) {


        int t = sc.nextInt();
        for(int T=1; T<=t; T++) {
            int p = sc.nextInt();
            int q = sc.nextInt();
            int N= 300;// p와q는 1~10,000
            HM = new HashMap<>();

            answer = solution(p,q,N);

            System.out.println("#" + T + " " + answer);
        }
    }

    //1,1
    //2,1 1,2
    //3,1 2,2 1,3
    //4,1 3,2 2,3 1,4..
    public static int solution(int p, int q, int N)
    {
        makeVertex(N);
        vertex a = new vertex(getKey(HM, p));
        vertex b = new vertex(getKey(HM, q));

        return getValue(HM,(a.p+b.p), (a.q+b.q));

    }

    public static int getValue(HashMap<vertex, Integer> m, int p, int q)
    {
        for(vertex o: m.keySet())
        {
            if(o.p == p && o.q == q)
            {
                return m.get(o);
            }
        }
        return 0;
    }

    public static vertex getKey(HashMap<vertex, Integer> m, int value)
    {
        for(vertex o: m.keySet())
        {
            if(m.get(o).equals(value))
            {
            return o;
            }
        }
        return null;
    }



    //1,1
    //2,1 1,2
    //3,1 2,2 1,3
    //4,1 3,2 2,3 1,4..
    public static void makeVertex(int N)
    {
        int idx = 1;
        for (int i = 1; i <= N; i++) {
            for (int j = i; j > 0; j--) {
                HM.put(new vertex(i-j+1,j),idx++);
            }
        }

    }

}

class vertex
{
    int p;
    int q;

    public vertex(int p, int q)
    {
        this.p = p;
        this.q = q;

    }
    public vertex(vertex target)
    {
        this.p = target.p;
        this.q = target.q;
    }

}