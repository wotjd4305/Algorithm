package TextBook.DP;

// https://school.programmers.co.kr/learn/courses/30/lessons/12904

public class 프로그래머스_가장긴팰린드롬_투포인터_윈도우 {
    public int solution(String s)
    {
        int answer = 1;

        // 큰 팰린드롬부터 찾기
        boolean isFound = false;
        for(int i=s.length()-1; i>=1; i--){
            for(int j=0; j<s.length() - i; j++){
                // 서브스트링으로 시간초과 에바지;;
                if(isPalindrome(s, j, j+i)){
                    // System.out.println(s.substring(j,j+i+1));
                    answer = i+1;
                    isFound = true;
                    break;
                }
            }
            if(isFound) {
                break;
            }
        }

        return answer;
    }

    public boolean isPalindrome(String target, int start, int end){
        for(int i=start, j=end; i < j; i++, j--){
            if(target.charAt(i) != target.charAt(j)){
                return false;
            }
        }
        return true;
    }
}
