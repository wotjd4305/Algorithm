package TextBook.PQ;

// https://school.programmers.co.kr/learn/courses/30/lessons/12927

import java.util.PriorityQueue;

public class 프로그래머스_야근지수_PQ {

    public long solution(int n, int[] works) {
        long answer = 0;
        boolean flag = false;

        PriorityQueue<Work> pq = new PriorityQueue<>();

        for(int i=0; i<works.length; i++){
            pq.add(new Work(works[i]));
        }

        for(int i=0; i<n; i++){
            if(pq.peek().work == 0){
                flag = true;
                break;
            }
            pq.add(new Work(pq.poll().work - 1));
        }

        if(flag){
            return answer;
        }

        for(int i=0; i<works.length; i++){
            answer += Math.pow(pq.poll().work, 2);
        }

        return answer;
    }


    public class Work implements Comparable<Work>{
        int work;
        public Work(int work){
            this.work = work;
        }

        @Override
        public int compareTo(Work p) {
            return p.work - this.work;
        }

        @Override
        public String toString(){
            return this.work + "";
        }
    }
}
