package main.java.Temp3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bac_암호만들기_G5_조합 {


    static String Arr[];
    static LinkedHashSet<String> lh = new LinkedHashSet<>();
    static ArrayList<String> al = new ArrayList<>();
    static int L;
    static int C;

    static StringBuffer sb = new StringBuffer();
    static String[] temp;
    static char[] charArr;


    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken()); //4
        C = Integer.parseInt(st.nextToken()); //6

        st = new StringTokenizer(br.readLine());
        Arr = new String[C];
        for(int i=0; i<C; i++){
            Arr[i] = st.nextToken();
        }

        solution();

        al = new ArrayList<>(lh);

        Collections.sort(al);

        for(String str : al){
            System.out.println(str);
        }
    }


    public static void solution(){

        temp = new String[L];
        comp(C,L);


    }

    public static void comp(int n, int r){
        if(r==0){
            //System.out.println(Arrays.toString(temp));
            sb.setLength(0);

            int count = 0;
            for(String s : temp) {
                if(s.contains("a") || s.contains("e")  || s.contains("i")  || s.contains("o")  || s.contains("u") )
                    count++;
                sb.append(s);
            }

            //만족할 떄만 모음 1개 이상 자음 2개이상
            if(count >=1 && count <= L-2) {

                //정렬
                charArr = sb.toString().toCharArray();
                Arrays.sort(charArr);
                String result = new String(charArr);

                //
                lh.add(result);
                //System.out.println("안옴?");
                return;
            }


            //어쨰뜻 끝
            return;

        }
        else if(n<r) {
            return;
        }
        else{
            temp[r-1] = Arr[n-1];
            comp(n-1, r-1);
            comp(n-1, r);
        }

    }
}
