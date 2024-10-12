//package Temp_2023;
//
//import java.util.*;
//
//public class L2_과제진행하기 {
//
//    public static void main(String args[]) {
//        //String[][] plans = {{"korean", "11:40", "30"}, {"english", "12:10", "20"}, {"math", "12:30","40"}};
//        String[][] plans = {{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}};
//
//        System.out.println(Arrays.toString(solution(plans)));
//    }
//
//    public static String[] solution(String[][] plans) {
//        String[] answer = {};
//
//        LinkedList<Plan> list = new LinkedList<>();
//        PriorityQueue<Plan> que = new PriorityQueue<>();
//
//        for(String[] str : plans){
//            String[] temp = str[1].split(":");
//            str[1] = String.valueOf(Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]));
//        }
//
//        for(String[] str : plans){
//            System.out.println(str[1]);
//        }
//
//        for(String[] str : plans){
//            list.add(new Plan(str[0], Integer.parseInt(str[1]), Integer.parseInt(str[2])));
//        }
//        Collections.sort(list);
//
//        for(Plan p : list){
//            System.out.println(p.toString());
//        }
//
//        // 0
//        String beforeName = list.get(0).name;
//        int beforeTime = list.get(0).startTime;
//        int beforeRemainTime = list.get(0).remainTime;
//        que.add(new Plan(beforeName, beforeTime, beforeRemainTime));
//        for(int i=1; i<list.size(); i++){
//            Plan now = list.get(i);
//
//        }
//
//
//        return answer;
//    }
//
//    public static class Plan implements Comparable<Plan>{
//        String name;
//        int startTime;
//        int remainTime;
//
//        public Plan(String name, int startTime, int remainTime) {
//            this.name = name;
//            this.startTime = startTime;
//            this.remainTime = remainTime;
//        }
//
//        @Override
//        public String toString() {
//            return "Plan{" +
//                    "name='" + name + '\'' +
//                    ", startTime=" + startTime +
//                    ", remainTime=" + remainTime +
//                    '}';
//        }
//
//        @Override
//        public int compareTo(Plan o) {
//            return this.startTime- o.startTime;
//        }
//    }
//}
