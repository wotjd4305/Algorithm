package exam.naver;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Solution2 {
   static int[] arr= { 2,1,3,8,0,1,2,1};

    //static int[] arr= {1,2,3};

    public static void main(String[] args) throws IOException {
        System.out.println(solution(arr));
    }

    public static int solution(int[] arr){

        Map<Integer, Integer> CardMap = new HashMap<Integer, Integer>();
        int answer = Integer.MAX_VALUE;

        for(int i =0; i<arr.length; i++){
            //키가 중복안되어있으면
            if(!CardMap.containsKey(arr[i])) {
                CardMap.put(arr[i], i);
            }
            //키가 중복이면
            else{
                int tempAnswer = i - CardMap.get(arr[i]);
                CardMap.put(arr[i], i);
                //System.out.println(i + ", " + CardMap.get(arr[i]));
                answer = Math.min(answer, tempAnswer);
            }
        }
        if(answer == Integer.MAX_VALUE) answer = -1; //중복 못찾았으면

        return answer;
    }


}
