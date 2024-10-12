package exam.NaverF_2023;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class testSolution1 {

    public static void main(String args[]){
        String[] v = {"DS7651 A0",
                "CA0055 D+",
                "AI5543 C0",
                "OS1808 B-",
                "DS7651 B+",
                "AI0001 F",
                "DB0001 B-",
                "AI5543 D+",
                "DS7651 A+",
                "OS1808 B-"};
        String[] result= solution(v);

        for(String s : result){
            System.out.println(s);
        }
    }

    public static String[] solution(String[] grades) {
        String[] answer = {};

        // init
        HashMap<String, Score> map = new HashMap<>();
        for(String str : grades){
            String[] temp = str.split(" ");
            String code = temp[0];
            Score score = Score.of(temp[1]);

            if(map.get(code) != null){
                map.put(code, (score.seq < map.get(code).seq) ? score : map.get(code));
            }
            else {
                map.put(code, score);
            }
        }

        List<Grade> list = new ArrayList<>();

        for(String key : map.keySet()){
            Score score = map.get(key);
            list.add(new Grade(key, score));
        }

        Collections.sort(list);


        List<String> strList = new ArrayList<>();
        strList = list.stream()
                .map(t -> t.code + " " + t.score.title)
                .collect(Collectors.toList());

        answer = strList.toArray(new String[list.size()]);

        return answer;
    }

    public static class Grade implements Comparable<Grade>{
        String code;
        Score score;

        public Grade(String code, Score score) {
            this.code = code;
            this.score = score;
        }

        @Override
        public int compareTo(Grade o) {
            return this.score.getSeq() - o.score.getSeq();
        }
    }

    public static enum Score{
        AP(0, "A+"),
        AZ(1, "A0"),
        AM(2, "A-"),
        BP(3, "B+"),
        BZ(4, "B0"),
        BM(5, "B-"),
        CP(6, "C+"),
        CZ(7, "C0"),
        CM(8, "C-"),
        DP(9, "D+"),
        DZ(10, "D0"),
        DM(11, "D-"),
        F(12, "F");
        int seq;
        String title;

        Score(int seq, String title) {
            this.seq = seq;
            this.title = title;
        }

        private static final Map<String, String> map = Collections.unmodifiableMap(
                Stream.of(values())
                        .collect(Collectors.toMap(Score::getTitle, Score::name)));

        public static Score of(String title){
            return Score.valueOf(map.get(title));
        }

        public int getSeq() {
            return seq;
        }
        public String getTitle() {
            return title;
        }
    }
}
