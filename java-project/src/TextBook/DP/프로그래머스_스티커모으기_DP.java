package TextBook.DP;

// https://school.programmers.co.kr/learn/courses/30/lessons/12971

public class 프로그래머스_스티커모으기_DP {

    public int solution(int sticker[]) {
        int answer = 0;

        if (sticker.length == 1) {
            return sticker[0];
        }
        if (sticker.length == 2) {
            return Math.max(sticker[0], sticker[1]);
        }

        int[] dp1 = new int[sticker.length - 1];

        // 첫번째 스티커
        dp1[0] = sticker[0];
        dp1[1] = sticker[0];
        for (int i = 2; i < sticker.length - 1; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + sticker[i]);
        }

        // 두번쨰 스티커
        int[] dp2 = new int[sticker.length];
        dp2[0] = 0;
        dp2[1] = sticker[1];
        for (int i = 2; i < sticker.length; i++) {
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + sticker[i]);
        }

        // 첫번째 경우와 두번쨰 경우 비교
        answer = Math.max(dp1[dp1.length - 1], dp2[dp2.length - 1]);
        return answer;
    }
}
