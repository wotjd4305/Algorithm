import java.util.*;
public class swe1213 {
    static Scanner sc  = new Scanner(System.in);
    public static void main(String[] args) {
        //split을 이용한 문자열이 포함된 숫자세기
        for(int T=1; T<=10; T++) {
            int tnumber = sc.nextInt();
            sc.nextLine();
            String strToFind = sc.nextLine();
            String strTxt = sc.nextLine();

            //맨끝에 strToFind가있을시에 오류.
            strTxt += " ";
            System.out.println("#" + tnumber + " " + (strTxt.split(strToFind).length-1));
        }
    }
}