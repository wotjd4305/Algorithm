package exam.toss;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class soltuion2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        Set<Integer> set = new TreeSet<>();
        for (String s : input) {
            set.add(Integer.parseInt(s));
        }

        System.out.println(getAnswer(input, set));
    }

    private static boolean getAnswer(final String[] input, final Set<Integer> set) {
        if (set.size() != 6) {
            return false;
        }

        int idx = 0;
        for (final int num : set) {
            if (num < 1 || num > 45) {
                return false;
            }

            if (Integer.parseInt(input[idx++]) != num) {
                return false;
            }
        }
        return true;
    }

}
