package exam.toss;


import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class soltuion7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputLine = br.readLine().split("; ");
        int sPos = Integer.parseInt(inputLine[0]);//스타팅


        //값 넣기
        int[] arr = new int[8];
        String[] strArr = inputLine[1].split(" ");
        for (int i = 0; i < 8; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }

        List<Node> list = new ArrayList<>();

        int cnt = 0;
        while (true) {
            if (sPos > 7 || sPos < 0) {
                break;
            } else if (arr[sPos] == 1) {
                list.add(new Node(arr[sPos], arr[sPos + 1]));
                break;
            } else if (arr[sPos] == 0) {
                list.add(new Node(arr[sPos], arr[sPos + 1]));
                sPos = arr[sPos + 1];
            }
            cnt++;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(0 + "; ");
        int count = 1;
        for (Node node : list) {
            if (node.compare == 0) {
                sb.append(node.compare).append(" ").append(count * 2).append(" ");
            } else {
                sb.append(node.compare).append(" ").append(node.num).append(" ");
            }
            count++;
        }

        for (int i = 0; i < 3 - cnt; i++) {
            sb.append(0 + " " + 0 + " ");
        }

        System.out.println(sb);
    }
    public static class Node {
        int compare;
        int num;

        public Node(final int compare, final int num) {
            this.compare = compare;
            this.num = num;
        }
    }

}



