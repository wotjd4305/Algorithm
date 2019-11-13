import java.util.*;

public class proPriorityQueue {

        public static long solution(int n, int[] works) {
            long answer = 0;
            int n_idx = 0;
            int buffer =0;
            long total = 0;

            PriorityQueue<Integer> AL = new PriorityQueue<>(Collections.reverseOrder());
            for(int i : works)
                AL.offer(i);

            for(int i : works)
                total += i;

            //시간이 충분할경우 바로 종료
            if(total <= n)
                return 0;

            while(n != n_idx)
            {
                n_idx++;
                buffer = AL.poll();
                AL.offer(--buffer);

            }

            for(int i : AL)
            {
                answer += Math.pow(i, 2);
            }

            return answer;
        }


    public static void main(String[] args) {

            int[] works = {4,3,3};
            int n = 4;


        System.out.println(solution(n, works));


    }



}
 
 
