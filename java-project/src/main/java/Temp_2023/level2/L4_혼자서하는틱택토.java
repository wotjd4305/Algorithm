package Temp_2023.level2;

import java.util.Arrays;

public class L4_혼자서하는틱택토 {

    // 북 북동 {동 동남 남} 남서 서 서북
    // 동 동남 남
//    static int[] dx = {-1,-1,0,0,1,1,0,-1};
//    static int[] dy = {0,1,1,1,0,0,-1,-1};
    static int[] dx = {0, 1, 1,1};
    static int[] dy = {1, 1, 0,-1};
    static final int YES = 1;
    static final int NO = 0;


    public static void main(String args[]) {

//        String[] board = {"O.X",".O.","..X"};
//        String[] board = {"OOO", "...", "XXX"};
//        String[] board = {"...",".X.","..."};
//        String[] board = {"OOO","...","XXX"};
//         String[] board = {"XXX", "XOO", "OOO"};


//          String[] board = {"OXX","OOX","OXO"};

          String[] board = {"...","...","..."};
        System.out.println(solution(board));
    }

    public static int solution(String[] board) {
        String[][] map = new String[3][3];

        for (int i = 0; i < 3; i++) {
            map[i] = board[i].split("");
        }

        long Ocount = Arrays.stream(map)
                .flatMap(t1 -> Arrays.stream(t1))
                .filter(t2 -> t2.equals("O"))
                .count();

        long Xcount = Arrays.stream(map)
                .flatMap(t1 -> Arrays.stream(t1))
                .filter(t2 -> t2.equals("X"))
                .count();

        long Oline = 0;
        long Xline = 0;

        System.out.println(Ocount +"," + Xcount);

        // 첫번째 행, 가로, 세로, 대각 확인
        for (int i = 0; i < 3; i++) {
            String value = map[0][i];

            for (int j = 0; j < 3; j++) {
                int count = 0;
                int nx = dx[j];
                int ny = i + dy[j];
                if (value.equals(".")) break;
                while (nx >= 0 && ny >= 0 && nx < 3 && ny < 3) {
                    if(value.equals(map[nx][ny])) {
                        count++;
                    }
                    nx = nx + dx[j];
                    ny = ny + dy[j];
                }
                if (count >= 2 && value.equals("O")) {
                    Oline++;
                }
                if (count >= 2 && value.equals("X")) {
                    Xline++;
                }
            }
        }

        // 나머지행 가로만 확인.
        for (int i = 1; i < 3; i++) {
            String value = map[i][0];
            int count = 0;

            int nx = i + dx[0];
            int ny = dy[0];
            if (value.equals(".")) continue;
            while (nx >= 0 && ny >= 0 && nx < 3 && ny < 3) {
                if(value.equals(map[nx][ny])) {
                    count++;
                }
                nx = nx + dx[0];
                ny = ny + dy[0];
            }
            if (count >= 2 && value.equals("O")) {
                Oline++;
            }
            if (count >= 2 && value.equals("X")) {
                Xline++;
            }
        }
        System.out.println("라인 수 : " + Oline + "," + Xline);

        // O X 갯수가 이상할떄
        if(Math.abs(Ocount - Xcount) >= 2){
            return NO;
        }

        // O X가 갯수가 같을 떄
        if (Ocount == Xcount) {
            // 무승부
            if(Oline == 0 && Xline == 0){
                System.out.println("O=X - 무승부");
                return YES;
            }
            // 후공인 X가 승리리
            if(Oline == 0 && Xline >= 1){
                System.out.println("X 승리");
                return YES;
            }
        }

        // O가 하나만 더 많을떄
        if (Ocount == Xcount + 1) {
            // 무승부
            if(Oline == 0 && Xline == 0){
                System.out.println("0이 하나더 많음 - 무승부");
                return YES;
            }

            // O가 승리
            // 후공인 X가 승리리
            if(Oline >= 1 && Xline == 0){
                System.out.println("0이 하나더 많음 - O 승리");
                return YES;
            }
        }

        return NO;
    }
}