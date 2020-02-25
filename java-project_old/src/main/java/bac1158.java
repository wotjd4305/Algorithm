import java.util.*;

public class bac1158 {

    //[1] [2] [3] [4] [5] [6] [7]
    //3, 6, 2, 7, 5, 1, 4
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        Queue<Integer> AnswerQueue = new LinkedList<>();
        ArrayList<Integer> ArrList = new ArrayList<>();

        for(int i=1; i<=N; i++)
        {
            AnswerQueue.offer(i);
        }

        while(!AnswerQueue.isEmpty())
        {
            if(AnswerQueue.size() == 1)
            {
                ArrList.add(AnswerQueue.poll());
                break;
            }

            for(int j =1; j < K; j++)
            {
              //  System.out.println("+" + AnswerQueue.peek());
                AnswerQueue.offer(AnswerQueue.poll());
            }

           // System.out.println("-" + AnswerQueue.peek());
            ArrList.add(AnswerQueue.poll());

        }

        //출력
        System.out.print("<");
        for(int i=0; i<ArrList.size(); i++)
        {
            if(i == ArrList.size()-1)
                System.out.print(ArrList.get(i));
            else
                System.out.print(ArrList.get(i) + ", " );
        }
        System.out.print(">");

    }





}

