package Temp_2023;

public class L2_DFS_타겟넘버 {

    static int plusAndMinus[] = {1, -1};
    static int answer = 0;
    static int[] Globalnumbers;

    public static void main(String args[]){
        int[] numbers = {4,1,2,1};
        int target = 4;
        System.out.println(solution(numbers, target));
    }

    public static int solution(int[] numbers, int target) {

        int level = 0;
        int total = 0;
        Globalnumbers = numbers;
        DFS(plusAndMinus[0], target, level, total);
        DFS(plusAndMinus[1], target, level, total);

        return answer;
    }


    public static void DFS(int plus_minus, int target, int level, int total) {
        total += plus_minus * Globalnumbers[level];

        if(Globalnumbers.length-1 == level){
            if(total == target) {
                answer++;
            }
            return;
        }
        DFS(plusAndMinus[0], target, level+1, total);
        DFS(plusAndMinus[1], target, level+1, total);
    }
}
