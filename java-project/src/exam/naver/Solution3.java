package exam.naver;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution3 {
    static int[] p = { 3,2,1,4,5};
    //static int[] p = { 20,10,10,20};
    //static int[] p = { 103,101,103,103,101,102,100,100,101,104};

    public static void main(String[] args) throws IOException {
        Map<Integer, Integer> CardMap = new HashMap<Integer, Integer>();
        int answer = 0;

        //Map에 데이터 입력
        for(int i =0; i<p.length; i++){
            CardMap.put(p[i], CardMap.getOrDefault(p[i],0)+1);
        }

        //정렬
        Object[] mapSort = CardMap.keySet().toArray();
        Arrays.sort(mapSort);

        //과정
        boolean isDone = false;
        while(!isDone) {
            isDone = true;

            for (Integer nKey : CardMap.keySet()) {
                if(CardMap.get(nKey) != 0){
                    answer++;
                    CardMap.put(nKey, CardMap.get(nKey) -1);
                    isDone = false;
                }
                //System.out.println(testMap.get(nKey));
            }
            answer--;
        }

        //마지막에 끝나면서 빼주었으니 다시 더해줌
        answer++;

        System.out.println(answer);
    }


}
