package Temp_2023;
import java.util.*;

public class L2_완탐_소수찾기 {

    public static void main(String args[]) {
        String str = "17";

        System.out.println(solution(str));
    }


    public static int solution(String numbers) {
        int answer = 0;

        String[] num_arr = numbers.split("");
        //중복x, 순서x
        HashSet<Integer> checked = new HashSet<>();

        for (int i = 0; i < num_arr.length; i++) {
            answer += makeNum(num_arr,  checked, "", 0, i + 1);
        }

        return answer;
    }

    private static int makeNum(String[] arr, HashSet<Integer> checked, String numString, int visited, int toPick) {
        if (toPick == 0) {
            int num = Integer.parseInt(numString);

            //중복검사
            if(checked.contains(num)) return 0;

            checked.add(num);

            //소수 판별
            if (isPrime(num)) return 1;

            return 0;
        }

        int ret = 0;

        //자기자신을 중복선택하지 않는 순열 생성 (visitied 사용여부에 따라)
        for (int i = 0; i < arr.length; i++) {
            if((visited & (1 << i)) > 0)
                continue;
            ret += makeNum(arr, checked, numString + arr[i], visited + (1 << i), toPick - 1);
        }

        return ret;

    }

    /* 소수판별 메소드 */
    private static boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;

        /**
         * num 이 p * q 라고 할때 한 수는 항상 sqrt(num) 이하의 값을 갖는다. (ex, num = 24, p = [1, 2, 3, 4], q = [6, 8, 12, 24])
         * 따라서 num 이 sqrt(num) 이하의 값중 하나로 나눠지는지 체크한다. (ex, 24 가 4 이하의 숫자로 나눠지는지 체크,, 1,2 는 예외)
         */
        int sqrtn = (int) Math.sqrt(num);//4
        for (int i = 3; i <= sqrtn; i += 2) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
