package main.java.Temp_2024;


public class L1_지폐접기 {


    public static void main(String args[]) {

        int[][] wallet = {{30, 15}, {50, 50}};
        int[][] bill = {{26, 17}, {100, 241}};

        for (int i = 0; i < wallet.length; i++) {
            System.out.println(solution(wallet[i], bill[i]));
        }
    }


    public static int solution(int[] wallet, int[] bill) {

        int result = 0;

        int billWidth = bill[0];
        int billHeight = bill[1];

        int walletWidth = wallet[0];
        int walletHeight = wallet[1];

        while (true) {
            // 지폐의 한면이 더 작은가
            if ((billWidth <= walletWidth && billHeight <= walletHeight)
                    || (billHeight <= walletWidth && billWidth <= walletHeight)) {
                break;
            }

            // 지폐의 긴면을 절반으로
            if(billWidth >= billHeight) {
                billWidth /= 2;
            } else {
                billHeight /= 2;
            }
            result ++;
        }

        return result;
    }
}
