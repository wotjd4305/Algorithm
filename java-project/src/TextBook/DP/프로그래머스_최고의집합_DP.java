package TextBook.DP;

// https://school.programmers.co.kr/learn/courses/30/lessons/12938

public class 프로그래머스_최고의집합_DP {

    public Integer[] solution(int n, int s) {
        Integer[] answer = new Integer[n];

        double dn = (double) n;
        double ds = (double) s;
        double d1 = (Math.ceil(ds/dn));

        int i1 = (int)(Math.ceil(d1));


        // 갯수 확인
        int floorCount = (i1 * n) - s;

        if(i1 == 1 && floorCount > 0){
            return new Integer[]{-1};
        }

        // 바닥 추가
        for(int i=0; i<floorCount; i++) {
            answer[i] =i1 -1;
        }

        // 기존 추가
        for(int i=floorCount; i<n; i++) {
            answer[i] =i1;
        }

        //Collections.sort(list);

        //answer = list.toArray(new Integer[list.size()]);
        return answer;
    }
}
