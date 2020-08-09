package exam.toss;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class soltuion5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] kimToss = br.readLine().split(" ");
        String[] leeToss = br.readLine().split(" ");

        int accumulate = 0;
        int len = kimToss.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int kim = Integer.parseInt(kimToss[i]);
            int lee = Integer.parseInt(leeToss[i]);
            int curFee = kim - lee;

            if (curFee <= 0) {
                accumulate += (curFee * -1);
                sb.append(0 + " ");
            } else {
                if (curFee >= accumulate) {
                    sb.append(curFee - accumulate + " ");
                    accumulate = 0;
                } else {
                    sb.append(0 + " ");
                    accumulate -= curFee;
                }
            }
        }

        System.out.println(sb);
    }

}
