import java.util.*;

class bac2798_blackjack {
    static int N = 1000001;
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Integer> AL = new ArrayList<>();
    static boolean[] visited;
    static int dst_value = 0;
    static int answer=0;

    public static void main(String[] args) {

        AL.clear();
        int input = sc.nextInt();
        dst_value = sc.nextInt();

        visited = new boolean[input];

        solution(input);


        System.out.println(answer);

    }

    public static void solution(int input)
    {
        //입력
        for(int i =0; i<input; i++)
            AL.add(sc.nextInt());

        Collections.sort(AL, Collections.reverseOrder());

        for(int i=0; i<AL.size(); i++) {
            visited[i] = true;
            dfs(i, 0, AL.get(i));

            if(answer == dst_value)
                break;

            visited[i] = false;
        }

    }

    public static void dfs(int start, int count, int sum)
    {
        if(dst_value < sum)
            return;
        if(count == 2) {
            answer = Math.max(answer, sum);
            return;
        }

        for(int i =0; i<AL.size(); i++)
        {
            if(i==start || (visited[i] == true))
                continue;
            if(answer == dst_value)
                break;

            visited[i] = true;
            dfs(i,count+1, sum+AL.get(i));
            visited[i] = false;
        }


    }

}