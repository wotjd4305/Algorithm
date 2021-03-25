package main.java.Temp3;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class pro_호텔방배정 {

    static long k = 10;
    static long room_number[] = {1,3,4,1,3,1};

    public static void main(String args[]){
        long temp[] = solution(k,room_number);

        for(long a : temp){
            System.out.print(a + " ");
        }
    }
    static HashMap<Long, Long> hm = new HashMap();

    public static long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];

        for(int s=0; s<room_number.length; s++) {
            answer[s] = find(room_number[s]);
        }
        return answer;
    }

    public static long find(long key){

        if(!hm.containsKey(key)){
            hm.put(key, key+1);
            return key;
        }

        long cur = hm.get(key);
        long nxt = find(cur);
        hm.put(key, nxt);
        return nxt;
    }
}
