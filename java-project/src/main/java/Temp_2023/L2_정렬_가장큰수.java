package Temp_2023;

import java.util.*;

public class L2_정렬_가장큰수 {

    public static void main(String args[]) {
        int numbers[] = {6, 10, 2};

        System.out.println(solution(numbers));
    }


    public static String solution(int[] numbers) {
        String answer = "";
        Integer[] integers = Arrays.stream(numbers)
                .boxed()
                .toArray(Integer[]::new);

        Arrays.sort(integers, new Comparator<Integer>(){

            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = String.valueOf(o1);
                String s2 = String.valueOf(o2);
                String add1 = s1 + s2;
                String add2 = s2 + s1;

                return Integer.parseInt(add2)- Integer.parseInt(add1);
            }
        });


        boolean first = true;
        for(int number : integers) {
            if(first && number == 0) {
                answer = "0";
                break;
            } else {
                first = false;
            }
            answer += Integer.toString(number);
        }
        return answer;
    }
}
