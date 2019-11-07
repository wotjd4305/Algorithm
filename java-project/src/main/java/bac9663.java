import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class bac9663 {
    static int[] iArr;
    static int count;
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        iArr=new int[N];
        nQueen(iArr, N, 0);
        System.out.println(count);
    }

    //퀸이 놓일수 있는가?
    //1,3
    static boolean promising(int[] iArr,int row) {
        for(int i=0; i<row; i++)
        {
            if(iArr[row] == iArr[i] || row-i == Math.abs(iArr[row] - iArr[i]))
                return false;
        }
        return true;
    }

    static void nQueen(int[] iArr,int N,int row) {
        for(int i=0;i<N;i++) {
            iArr[row]=i;
            //퀸이 놓일수 있다면? 다음 행에 대해 퀸을 놓는다. 혹은 마지막 행이면 count수를 증가시켜준다.
            if(promising(iArr,row)) {
                if(row==N-1) count++;
                else {
                    nQueen(iArr, N, row+1);
                }
            }
        }
    }

}

