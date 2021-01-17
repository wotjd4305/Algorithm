package main.java.Temp2;

public class proDFS1 {
        static int plusAndMinus[] = {1, -1};
        static int answer = 0;
        static int[] Globalnumbers;
        static int count =0;

    public static void main(String[] args) {

        int[] number= {1,1,1,1,1,1,1};
        int target = 3;

        System.out.println(solution(number, target));


    }

        public static int solution(int[] numbers, int target) {

            int level = 0;
            int total = 0;
            Globalnumbers = numbers;
            DFS(plusAndMinus[0],target, level, total);
            DFS(plusAndMinus[1],target, level, total);


            return answer;

        }


        public static void DFS(int plus_minus, int target ,int level, int total)
        {
            count++;
            //연산
            total = total + plus_minus*Globalnumbers[level];

            //마무리
            if(level == Globalnumbers.length-1)
            {
                System.out.println("카운트 : " + count);
                System.out.println("비교전 : " + total + " " + target);
                if(target == total)
                {
                    System.out.println(total +"비교후 토탈");
                    answer++;
                    return;
                }
                System.out.println(total +"비교후 정답 아닌것");

                return;
            }

            DFS(plusAndMinus[0], target, level+1, total);
            DFS(plusAndMinus[1], target, level+1, total);

        }
    }



