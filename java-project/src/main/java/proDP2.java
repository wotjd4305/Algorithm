public class proDP2 {

    public static void main(String[] args) {


        int[][] triangle = {{7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}};
        System.out.println(solution(triangle));
        //showArray(triangle);
    }


    public static int solution(int[][] triangle) {
        int answer = 0;
        int idx = 1;

        //1)겉에꺼 처리
        //i=0일때 길이1, i=1일때 길이2
        for(int i =1; i<triangle.length; i++)
        {

            int ex_end_idx = triangle[i-1].length-1;
            int after_end_idx = triangle[i].length-1;

            //
            triangle[i][0] += triangle[i-1][0];
            triangle[i][after_end_idx] += triangle[i-1][ex_end_idx];

        }

        //2)속에꺼 처리리
       //규칙
        //i는 2부터 시작하면 됨.
        // 2,1은  1,0과 1,1 둘중하나 -> 식으로가능
        // 4,1은 3,0과 3,1 둘중하나
        for(int i =2; i<triangle.length; i++)
            for(int j =1; j<triangle[i].length-1; j++)
            {
                triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
            }

        answer = findMaxValue(triangle);
        return answer;
    }

    public static int findMaxValue(int[][] Array)
    {
        int max =0;
        //맨 밑에 있는 애들
        for(int i=0; i<Array[Array.length-1].length; i++)
        {
           max = Math.max(Array[Array.length-1][i], max);

        }

        return max;
    }

    public static void showArray(int[][] Array)
    {
        for(int[] i : Array) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

    }


}



