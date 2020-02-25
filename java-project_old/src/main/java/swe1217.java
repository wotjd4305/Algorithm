import java.util.Scanner;

public class swe1217 {
    static Scanner sc  = new Scanner(System.in);
    public static void main(String[] args) {
        for(int T=1; T<=10; T++) {
            int tnumber = sc.nextInt();
            sc.nextLine();

            double a = sc.nextDouble();
            double b = sc.nextDouble();

            //맨끝에 strToFind가있을시에 오류.
            System.out.println("#" + tnumber + " " + (int)(Math.pow(a,b)));
        }
    }
}