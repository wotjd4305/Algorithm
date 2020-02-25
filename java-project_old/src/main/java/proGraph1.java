import java.util.*;


public class proGraph1{

    public static void main(String[] args) {

        int edge[][] = {{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}};
        int n = 6;
        System.out.println(solution(n,edge));
    }
    public static int solution(int n, int[][] edge) {
        ArrayList<ArrayList<Integer>> list = new <ArrayList<Integer>> ArrayList();
        Queue<Integer> q = new LinkedList<Integer>();

        //n이 6이면 n개의 배열이고  {1,2}, {1,3}
        for(int i = 0; i < edge.length; i++) {
            list.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < edge.length; i++) {
            int m = edge[i][0];
            int h = edge[i][1];
            //앞뒤로 채움, 인접행렬같이.. ArrayList는 1부터 시작. 즉 1,2,3,4,5,6
            list.get(m).add(h);
            list.get(h).add(m);
        }

        //최소 거리
        int[] d = new int[n+1];
        Arrays.fill(d, -1);

        //첫번째니까 0
        d[1] = 0;
        q.add(1);
        int u = 0;

        //전형적인 BFS,
        while(q.size() > 0) {
            //처음에는 1부터 시작이니 u=1
            u = q.poll();
            //처음회전에는 {1,3} {1,2}니까 e = 3과 2가나옴
            for(int e : list.get(u)) {
                if(d[e] == -1) {
                    d[e] = d[u]+1;
                    q.add(e);
                }
            }

        }

        int count = 0;
        int max = 0;
        for(int i : d)
        {
            max = Math.max(max, i);
        }
        for(int i : d)
        {
            if(max == i)
                count++;
        }

        return count;
    }
}


