package Temp_2023.level2;//package Temp_2023;

import java.util.LinkedList;
import java.util.Queue;

public class L2_리코쳇로봇_진짜 {

    //상하좌우
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};

    public static void main(String args[]) {
        String board[] = {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};
        System.out.println(solution(board));
    }

    public static int solution(String[] board) {
        int answer = 0;

        String[][] map = new String[board.length][board[0].length()];
        int[][] count = new int[board.length][board[0].length()];
        boolean[][] visitied = new boolean[board.length][board[0].length()];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length(); j++) {
                map[i] = board[i].split("");
            }
        }

        Queue<Point> qu = new LinkedList<>();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j].equals("R")) {
                    qu.add(new Point(i, j));
                    visitied[i][j] = true;
                    count[i][j] = 1;
                    System.out.println(i + "," + j);
                    break;
                }
            }
        }

        Point answerPoint = null;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j].equals("G")) {
                    answerPoint = new Point(i,j);
                }
            }
        }
        
        while (!qu.isEmpty()) {
            Point now = qu.poll();
            int x = now.x;
            int y = now.y;
            visitied[x][y] = true;
            System.out.println("나옴 : " + x + "," + y + " : " + count[x][y]);

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                // 범위 넘지않으면
                while (nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length && !map[nx][ny].equals("D")) {
                    System.out.println("새로운 좌표 : " + nx + "," + ny);
                    nx += dx[i];
                    ny += dy[i];
                }
                nx -= dx[i];
                ny -= dy[i];

                if (visitied[nx][ny]) {
                    continue;
                }

                visitied[nx][ny] = true;
                qu.offer(new Point(nx, ny));
                count[nx][ny] = count[x][y] + 1;
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length(); j++) {
                System.out.print(count[i][j] + " ");
            }
            System.out.println();
        }


        return count[answerPoint.x][answerPoint.y] == 0 ? -1 : count[answerPoint.x][answerPoint.y] -1;
    }

    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
