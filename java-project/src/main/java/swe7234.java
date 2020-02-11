import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

class swe1228 {
    static LinkedList<String> LL = new LinkedList<>();
    static int Length;
    static int IN;
    static String[] NumberArr;
    static String[] InsArr;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String args[]) throws Exception {
        for (int test_case = 1; test_case <= 10; test_case++) {

            LL.clear();
            init();
            solution();
            String buffer = "";

            for(int i =0; i<10; i++)
                buffer += LL.get(i) + " ";

            // 출력
            System.out.println("#" + test_case + " " + buffer);
        }
    }

    public static void solution() {
        //1->9 i(1) + 1 + number(5) + 2
        for(int i=1; i<InsArr.length; ) {

            //11 ~ 16
            int start_idx = Integer.parseInt(InsArr[i]);
            int number = Integer.parseInt(InsArr[i+1]);
            for(int j=(i + number +1 ); j>=i+2; j--) {
                LL.add(start_idx, InsArr[j]);
            }
            i = i + number + 3;
        }
    }


    public static void init() throws NumberFormatException, IOException {
        Length = Integer.parseInt(br.readLine());
        String temp[] = br.readLine().split(" ");
        for(String str : temp)
            LL.add(str);
        IN =Integer.parseInt(br.readLine());
        InsArr = (br.readLine().split(" "));
    }
}