import java.util.Arrays;

public class proBinary1 {

    static int answer = 0;

    public static void main(String[] args) {

        int budgets[] = {122,122,300,600};
        int M = 485;


        System.out.println(solution(budgets, M));


    }

    public static int solution(int[] budgets, int M) {

        //오름차순 정렬, 110 120 140 150
        Arrays.sort(budgets);
        int total =0;

        int avg;
        int low = 0;
        int high = budgets[budgets.length-1];
        int temp = 0;
        boolean flag = false;

        //처음에 초기화
        avg = (low+high)/2;

        while(true)
        {
            total = 0;
            temp = avg;
            //안바뀌면 이게 답, flag없으면 안돌고와서 0 == 0 해서 바로끝남
            if(temp == (low+high)/2 && flag)
            {
                answer = avg;
                break;
            }
            avg = (low+high) / 2;


            //넘으면 넘긴게 빼고고
            for(int i=0; i<budgets.length; i++)
            {
                if(avg <= budgets[i])
                    total += avg;
                else
                    total += budgets[i];
            }

            //예산 초과면, low를 높여서 더 제한
            if(total > M)
            {
                high = (high+low)/2 -1;
            }
            else if(total < M)
            {
                low = (high+low)/2 +1; // 0->1
            }
            else//예산에 딱맞다
            {
                answer = avg;
                break;
            }
            //한번은 돌았다.
            flag = true;
        }
        return answer;
    }
}