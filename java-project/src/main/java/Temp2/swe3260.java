package main.java.Temp2;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class swe3260 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();


        //테스트케이스
        for(int t=0; t<T; t++) {
            BigDecimal A= new BigDecimal(sc.next());
            BigDecimal B= new BigDecimal(sc.next());

            BigDecimal hap = A.add(B);
            System.out.println("#" + (t+1) + " " + hap);


        }


    }


}