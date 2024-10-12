package main.java.Temp2024;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeSet;

public class L1_공원 {

  static boolean[][] isVisited;
  static String[][] park;
  // 동 서 남 북
  static int dx[] = {0, 0, 1, -1};
  static int dy[] = {1, -1, 0, 0};

  static int maxValue = -1;

  public static void main(String args[]) {
    int[] mats = {5, 3, 2};
    park = new String[][]{{"A", "A", "-1", "B", "B", "B", "B", "-1"},
        {"A", "A", "-1", "B", "B", "B", "B", "-1"},
        {"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1"},
        {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"},
        {"D", "D", "-1", "-1", "-1", "-1", "-1", "F"},
        {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"}};

    isVisited = new boolean[park.length][park[0].length];

    System.out.println("##" + solution(mats, park));
  }

  public static int solution(int[] mats, String[][] park) {
    ArrayList<PriorityQueue<Point>> pqList = new ArrayList<>();

    for (int row = 0; row < park.length; row++) {
      for (int col = 0; col < park[0].length; col++) {
        TreeSet<Point> treeSet = new TreeSet<>();
        Queue<Point> que = new LinkedList<>();

        if (!park[row][col].equals("-1") && !isVisited[row][col]){
          Point startPoint = new Point(row, col);
          isVisited[row][col] = true;
          que.add(startPoint);
        }

        while (!que.isEmpty()) {
          Point currentQue = que.poll();
          treeSet.add(new Point(currentQue.x, currentQue.y));

          for (int i = 0; i < 4; i++) {
            int nx = currentQue.x + dx[i];
            int ny = currentQue.y + dy[i];
            if (isRange(nx, ny) && !park[nx][ny].equals("-1") && !isVisited[nx][ny]) {
              isVisited[nx][ny] = true;
              que.add(new Point(nx, ny));
            }
          }
        }

        // 계산 Max - Min하면 가로 세로 뚝닥해서 작은 값 기준으로 확인.
        // 0,0 1,1 -> 2,2
        // (0,3) (1,6) -> 2,4
        if (!treeSet.isEmpty()) {
          Point minPoint = treeSet.first();
          Point maxPoint = treeSet.last();

          int width = maxPoint.x - minPoint.x + 1;
          int height = maxPoint.y - minPoint.y + 1;

          int minValue = Math.min(width, height);
          for (int i = 0; i < mats.length; i++) {
            if (mats[i] <= minValue) {
              maxValue = Math.max(maxValue, minValue);
              break;
            }
          }
        }
      }
    }

    return maxValue;
  }

  public static boolean isRange(int x, int y) {
    return x >= 0 && y >= 0 && x < park.length && y < park[0].length;
  }

  public static class Point implements Comparable<Point> {

    int x;
    int y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public int compareTo(Point o) {
      return (this.x + this.y) - (o.x + o.y);
    }

    @Override
    public String toString() {
      return "Point{" +
          "x=" + x +
          ", y=" + y +
          '}';
    }
  }
}
