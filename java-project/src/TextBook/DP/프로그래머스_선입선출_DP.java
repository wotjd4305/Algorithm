package TextBook.DP;

// https://school.programmers.co.kr/learn/courses/30/lessons/12920

public class 프로그래머스_선입선출_DP {

    public int solution(int n, int[] cores) {
        // n = 8;
        // cores = new int[]{1,2,3,4};

        int answer = 0;
        int min = 0;
        int max = 10000*n;

        int time = 0;
        int midCount = 0;

        while (true) {
            int mid = (min+max)/2;

            int count;
            if(mid == 0) {
                count = 0;
            } else {
                count = cal(mid, cores);
            }
            // System.out.println(mid + "|" + min + "|" + max + ":" + count + ":" + time);

            if(min>max){
                break;
            }

            if (count >= n) {
                max = mid-1;
                time = mid;
                midCount = count;
            }else{
                min = mid+1;
            }
        }

        midCount = midCount - n;
        // System.out.println(time + "|" + midCount);
        for(int i = cores.length-1; i>=0; i--){
            if (time % cores[i] == 0) {
                if (midCount == 0) { // 해당초에 처리할 수 있는 코어
                    answer = i+1;
                    break;
                }
                midCount--;
            }
        }

        return answer;
    }

    static int cal(int time, int[] cores){
        int count = cores.length;
        for(int i = 0; i<cores.length; i++){
            count += (time/cores[i]);
        }
        return count;
    }
}
