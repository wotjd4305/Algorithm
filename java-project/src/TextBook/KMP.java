package TextBook;

public class KMP {

    //파이테이블 각 길이별로 접두사==접미사의 최대길이가 저장된 배열
    static int[] getPi(String pattern){

        int pi[] = new int[pattern.length()];
        int j = 0;
        for(int i = 1; i<pattern.length(); i++){
            //맞으면
            if(pattern.charAt(i) == pattern.charAt(j)){
                //i길이의 문자열의 공통길이는 j의 위치 + 1
                pi[i] = ++j;
            }
            //안맞으면
            else{
                if(j==0) continue;
                //맞을 떄까지.. 하나 전칸에서의 공통부분 위치로 이동
                while(pattern.charAt(i) != pattern.charAt(j))
                    j = pi[j-1];
            }
        }
        return pi;
    }

    static void KMP(String origin, String pattern){
        int[] pi = getPi(pattern);
        int j = 0;

        for(int i =0; i<origin.length(); i++){
               while(j>0 && origin.charAt(i) != pattern.charAt(j))
                    j = pi[j-1];
            //맞는 경우
            if(origin.charAt(i) == pattern.charAt(j)){
                if(j== pattern.length() -1){
                    System.out.println("ok" + (i - pattern.length() +1));
                    j= pi[j];
                }
                //맞았찌만 패턴이 끝나지 않았따면 j를 하나 증가
                else
                    j++;
            }
        }
    }

    public static void main(String args[]){
        String origin = "HELLOSSAFY";
        String pattern = "LOSS";

        KMP(origin, pattern);
    }
}
