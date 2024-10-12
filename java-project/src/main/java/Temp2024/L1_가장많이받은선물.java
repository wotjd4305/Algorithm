package main.java.Temp2024;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class L1_가장많이받은선물 {

  public static void main(String args[]) {

    String[][] friends = {{"muzi", "ryan", "frodo", "neo"},
        {"joy", "brad", "alessandro", "conan", "david"}, {"a", "b", "c"}};
    String[][] gifts = {
        {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi",
            "frodo ryan", "neo muzi"},
        {"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro",
            "alessandro david"}, {"a b", "b a", "c a", "a c", "a c", "c a"}};

    for (int i = 0; i < 3; i++) {
      System.out.println("##" + solution(friends[i], gifts[i]));
    }
  }

  public static int solution(String[] friends, String[] gifts) {
    AtomicInteger result = new AtomicInteger(-1);

    HashMap<String, HashMap<String, Integer>> hm = new HashMap<>();
    HashMap<String, GiftPoint> scoreHm = new HashMap<>();

    // 초기화
    for (int i = 0; i < friends.length; i++) {
      hm.put(friends[i], new HashMap<>());
      scoreHm.put(friends[i], new GiftPoint(0, 0));
    }

    for (int i = 0; i < gifts.length; i++) {
      String[] splited = gifts[i].split(" ");
      String from = splited[0];
      String to = splited[1];

      HashMap<String, Integer> currentHm = hm.get(from);
      currentHm.put(to, currentHm.getOrDefault(to, 0) + 1);
    }
    // 선물 주고 받기
    hm.forEach((from, toMap) -> {
      toMap.forEach((to, count) -> {
        // from이 to에게 count 만큼 선물을 주었을 때
        scoreHm.get(from).addTo(count); // from의 점수 증가
        scoreHm.get(to).addFrom(count);       // to의 점수 증가
      });
    });

    // 선물 주고받는 결과 출력
    hm.forEach((from, toMap) -> {
      toMap.forEach((to, count) -> {
//        System.out.println(from + "가 " + to + "에게 " + count + "개 선물함");
      });
    });

    // 점수 출력
    scoreHm.forEach((friend, giftPoint) -> {
//      System.out.println(friend + "의 점수: " + giftPoint);
    });

    int[] score = new int[friends.length];

    for (int i = 0; i < friends.length; i++) {
      for (int j = 0; j < friends.length; j++) {
        // 같은건 스킵
        if (i == j) {
          continue;
        }

        // 주고받은 크기가 같으면
        HashMap<String, Integer> from = hm.get(friends[i]);
        HashMap<String, Integer> to = hm.get(friends[j]);

        // 주고 받은 선물이 같으면
        if (Objects.equals(from.getOrDefault(friends[j], 0), to.getOrDefault(friends[i], 0))) {
          // 선물 포인트가 더 크면
          if (scoreHm.get(friends[i]).getPoint() > scoreHm.get(friends[j]).getPoint()) {
            score[i]++;
            continue;
          }
          continue;
        } else if (from.getOrDefault(friends[j], 0) > to.getOrDefault(friends[i], 0)) {
          score[i]++;
          continue;
        }
      }
    }

    Arrays.stream(score).forEach(t -> result.set(Math.max(t, result.get())));

    return result.get();
  }

  public static class GiftPoint {

    int from;
    int to;

    public GiftPoint(int to, int from) {
      this.from = from;
      this.to = to;
    }

    public void addFrom(int from) {
      this.from += from;
    }

    public void addTo(int to) {
      this.to += to;
    }

    public int getPoint() {
      return to - from;
    }

    @Override
    public String toString() {
      return "GiftPoint{" + "from=" + from + ", to=" + to + ", point=" + getPoint() + '}';
    }
  }
}
