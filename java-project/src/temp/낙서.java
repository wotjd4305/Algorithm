package temp;

import java.util.Scanner;
import java.util.regex.Pattern;

enum Season { //class 외부에서 선언
    봄, 여름, 가을, 겨울
}


public class 낙서 {

    public static Scanner sc = new Scanner(System.in);
    public static void main(String args[]) {
        String name = "홍길동";
        String tel = "010-1234-5678";
        String email = "test@naver.com";
        String temp = "abcbBc";

        //유효성 검사
        boolean name_check = Pattern.matches("^[가-힣]*$", name);
        boolean tel_check = Pattern.matches("^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$", tel);
        boolean email_check = Pattern.matches("\\w+@\\w+\\.\\w+(\\.\\w+)?", email);
        boolean temp_check = Pattern.matches("^[a-z]*$", temp);

        temp.matches(".*[a-zA-Z].*");

        //출력
        System.out.println("이름 : " + name_check);
        System.out.println("전화번호 : " + tel_check);
        System.out.println("이메일 : " + email_check);
        System.out.println("소문자 : " + temp.matches(".*[a-zA-Z].*"));

    }

}
