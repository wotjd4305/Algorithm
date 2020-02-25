import java.util.HashMap;
import java.util.Scanner;

public class temp2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        //테스트케이스
        for(int t=0; t<T; t++) {
            String A = sc.next();
            String B = sc.next();
            int count = 0;

            HashMap<String, Integer> Hm = new HashMap<>();
            HashMap<String, Integer> bufferHm = new HashMap<>();

            for(int i =0; i<B.length(); i++)
            {
                Hm.put("" + B.charAt(i), Hm.getOrDefault("" + B.charAt(i), 0) +1);
            }

            //CADB CAAB DACAB
            //CAADB
            //13, 5
            System.out.print(A.length()- B.length());
            for(int i=0; i<=A.length()-B.length(); i++)
            {
                bufferHm.clear();
                //0~4. 8~12
                for(int j=i; j<i+B.length(); j++)
                {
                    System.out.println("str = " + A.charAt(j));
                    bufferHm.put("" + A.charAt(j), bufferHm.getOrDefault("" + A.charAt(j), 0) +1);
                }

                boolean flag = false;
                for(String str : bufferHm.keySet()) {

                    System.out.println(str + " : " + bufferHm.get(str) + " - " + Hm.get(str));
                    if (!bufferHm.get(str).equals(Hm.get(str)))
                        flag = true;
                }
                if(flag == false)
                  count++;
                System.out.println();
            }


            System.out.println("#" + t + " - " + count);

        }


    }
}

