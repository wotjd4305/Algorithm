import java.util.*;

public class swe1221 {
    static Scanner sc  = new Scanner(System.in);
    static String[] answer;
    public static void main(String[] args) {
        sc.nextInt();
        for(int T=1; T<=10; T++) {
            HashMap<String, Integer> map = new HashMap<>();
            sc.next();
            int N = sc.nextInt();

            //입력
            MapInput(map, N);

/*


            //출력
            while (it.hasNext()) {
                answer[index++] = (String) it.next();
            }
*/

            //출력
            System.out.println("#" + T);
            MapOutput(map);

        }
    }

    public static List sortByValue(HashMap map)
    {
        List<Integer> list = new ArrayList<>();
        list.addAll(map.keySet());


        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        return list;
    }

    public static void MapOutput(HashMap<String, Integer> map)
    {
        int M;
        String buffer;

        buffer = "ZRO";

        M = map.get(buffer);
        for(int i=0; i<M; i++)
            System.out.print(buffer +" ");

        buffer = "ONE";
        M = map.get(buffer);
        for(int i=0; i<M; i++)
            System.out.print(buffer +" ");

        buffer = "TWO";
        M = map.get(buffer);
        for(int i=0; i<M; i++)
            System.out.print(buffer +" ");

        buffer = "THR";
        M = map.get(buffer);
        for(int i=0; i<M; i++)
            System.out.print(buffer +" ");

        buffer = "FOR";
        M = map.get(buffer);
        for(int i=0; i<M; i++)
            System.out.print(buffer +" ");

        buffer = "FIV";
        M = map.get(buffer);
        for(int i=0; i<M; i++)
            System.out.print(buffer +" ");

        buffer = "SIX";
        M = map.get(buffer);
        for(int i=0; i<M; i++)
            System.out.print(buffer +" ");

        buffer = "SVN";
        M = map.get(buffer);
        for(int i=0; i<M; i++)
            System.out.print(buffer +" ");

        buffer = "EGT";
        M = map.get(buffer);
        for(int i=0; i<M; i++)
            System.out.print(buffer +" ");

        buffer = "NIN";
        M = map.get(buffer);
        for(int i=0; i<M; i++)
            System.out.print(buffer +" ");



    }

    public static void MapInput(HashMap<String, Integer> map, int N)
    {
        for(int i=0; i<N; i++)
        {
            String buffer = sc.next();
            map.put(buffer,map.getOrDefault(buffer,0) +1);
            }
        }
    }

