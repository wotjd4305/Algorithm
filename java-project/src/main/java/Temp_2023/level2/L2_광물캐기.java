package Temp_2023.level2;//package Temp_2023;

import java.util.*;

public class L2_광물캐기 {

    static int visited[];
    static int total = 0;
    static int answer = Integer.MAX_VALUE;

    public static void main(String args[]) {
        // 다이아, 철, 돌
        int[] picks = {1, 3, 2};
        String[] mineral = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};

        System.out.println(solution(picks, mineral));
    }

    public static int solution(int[] picks, String[] minerals) {
        visited = new int[picks.length];
        for (int pick : picks) {
            total += pick;
        }
        for (int i = 0; i < picks.length; i++) {
            if (picks[i] == visited[i]) {
                continue;
            }

            visited[i]++;
            DFS(1, i, 0, 0, picks, minerals);
            visited[i]--;
        }

        return answer;
    }

    public static void DFS(int count, int pickIdx, int dept, int piro, int[] picks, String[] mineral) {
        if (answer <= piro || dept >= mineral.length) {
            return;
        }

        int add = 0;

        for (int i = dept; i < dept + 5; i++) {
            if (i >= mineral.length) {
                break;
            }
            String mineralTemp = mineral[i];

            switch (pickIdx){
                // 다이아
                case 0 :
                    add += 1;
                    break;
                // 철
                case 1:
                    add += mineralTemp.equals("diamond") ? 5 : 1;
                    break;
                // 돌
                case 2:
                    if(mineralTemp.equals("diamond")) add += 25;
                    else if(mineralTemp.equals("iron")) add += 5;
                    else add += 1;
                    break;
            }
        }

        // 곡괭이를 다썼거나 광물을 다캤을 경우
        if (count >= total || dept + 5 >= mineral.length) {
            answer = Math.min(answer, piro + add);
            return;
        }


        // 곡괭이 선택
        for (int i = 0; i < picks.length; i++) {
            // 곡괭이를 다썼거나, 없는 곡갱이면 다시 뽑기
            if (picks[i] == 0 || picks[i] == visited[i]) {
                continue;
            }
            visited[i]++;
            DFS(count + 1, i, dept + 5, piro + add, picks, mineral);
            visited[i]--;
        }
    }
}
