package exam.NaverF_2023;

import java.util.*;

public class testSolution2 {

    public static void main(String args[]){
        int[] s1 = {9,3,7,7,5,5,3,3};
        int[] s2 = {3,3,5,7,5,7,3,9};

        long[] result= solution(s1, s2);
        System.out.println(result[0] + ":" + result[1]);
    }

    public static long[] solution(int[] s1, int[] s2) {
        long[] answer = {0,0};

        // 중복제거값
        HashSet<Integer> hashSet = new HashSet<>();
        for(int num : s1){
            hashSet.add(num);
        }

        //
        List<Point> points = new ArrayList<>();
        for(int num : hashSet){
            int minValue = 0;
            int idx1 = 0;
            int idx2 = 0;

            for(int i=0; (s1.length > idx1 && s1.length > idx2); i++){
                if(s1[idx1] == num && s1[idx1] == s2[idx2]){
                    minValue += Math.abs(idx2 - idx1);
                    idx1++;
                    idx2++;
                }
                // s1이 선택 번호와 같으면
                else if(s1[idx1] == num && s2[idx2] != num){
                    idx2++;
                }
                // s2가 선택번호와 같으면
                else if(s1[idx1] != num && s2[idx2] == num){
                     idx1++;
                } else {
                    idx1++;
                    idx2++;
                }
            }
            points.add(new Point(num, minValue));
        }

        Collections.sort(points);
        Point result = points.get(0);
        answer[0] = result.selectNum;
        answer[1] = result.count;

        return answer;
    }

    public static class Point implements Comparable<Point>{
        int selectNum;
        int count;

        public Point(int selectNum, int count) {
            this.selectNum = selectNum;
            this.count = count;
        }

        @Override
        public int compareTo(Point o) {
            if(this.count == o.count) {
                return this.selectNum - o.selectNum;
            }
            return this.count - o.count;
        }
    }
}
