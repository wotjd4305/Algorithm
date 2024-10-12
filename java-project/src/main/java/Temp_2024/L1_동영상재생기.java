package main.java.Temp_2024;


public class L1_동영상재생기 {

    private static final String prev = "prev";
    private static final String next = "next";
    private static final String seperator = ":";

    public static void main(String args[]) {
        String[][] sizes = {{"34:33", "13:00", "00:55", "02:55", "13:00"},
                {"10:55", "00:05", "00:15", "06:55", "13:00"},
                {"07:22", "04:05", "00:15", "04:07", "13:00"}};

        String[][] commands = {{next, prev},
                {prev, next, next},
                {next}
        };

        for (int i = 0; i < sizes.length; i++) {
            System.out.println(solution(sizes[i][0], sizes[i][1], sizes[i][2], sizes[i][3], commands[i]));
        }
    }


    public static String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";

        Long startTime = calTime(pos);
        Long opStartTime = calTime(op_start);
        Long opEndTime = calTime(op_end);

        Long videoEndTime = calTime(video_len);

        for(int i =0; i<commands.length; i++) {

            // 오프닝에 속하는지
            if(opStartTime <= startTime && startTime <= opEndTime) {
                startTime = opEndTime;
            }

            // 명령 수행
            if(commands[i].equals(prev)) {
                startTime -= 10L;
            }
            if(commands[i].equals(next)) {
                startTime += 10L;
            }

            // 오프닝에 속하는지
            if(opStartTime <= startTime && startTime <= opEndTime) {
                startTime = opEndTime;
            }

            // 비디오의 시작보다 뒤 인지
            if(startTime < 0) {
                startTime = 0L;
            }

            // 비디오의 끝인지
            if(videoEndTime < startTime) {
                startTime = videoEndTime;
            }
        }

        return LongToTime(startTime);
    }

    public static Long calTime(String time) {
        Long result = 0L;

        String hours = time.split(seperator)[0];
        String minutes = time.split(seperator)[1];

        result += Long.parseLong(hours) * 60;
        result += Long.parseLong(minutes);

        return result;
    }

    public static String LongToTime(Long time) {
        String hours = String.format("%2s", String.valueOf(time / 60)).replace(' ', '0');
        String times = String.format("%2s", String.valueOf(time % 60)).replace(' ', '0');

        return hours + ":" + times;
    }
}
