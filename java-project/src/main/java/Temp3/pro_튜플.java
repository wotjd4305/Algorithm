package main.java.Temp3;

import java.util.*;

public class pro_튜플 {

    static String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";

    public static void main(String args[]){

        solution(s);

    }

    public static int[] solution(String s){
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Integer,Integer> hm = new HashMap<>();
        String test[] = s.split("}");

        for(int i=0; i<test.length; i++){
           test[i] = test[i].replaceAll("\\{","");
        }

        for(String str : test){
            String temp[] = str.split(",");
            for(String str2 : temp){
                if(!str2.equals("") && Integer.parseInt(str2) != 0) {
                    hm.put(Integer.parseInt(str2), hm.getOrDefault(Integer.parseInt(str2),0) + 1);
                }
            }
        }

        List<Map.Entry<Integer,Integer>>entry = new ArrayList<>(hm.entrySet());
        Collections.sort(entry, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> obj1, Map.Entry<Integer, Integer> obj2) {
                if(obj1.getValue() < obj2.getValue()) return 1;
                else if(obj1.getValue() == obj2.getValue()) return 0;
                else return -1;
            }
        });

        for(Map.Entry<Integer, Integer> i : entry){
            answer.add(i.getKey());
        }

        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
