package TextBook.DP;

class 프로그래머스_보행자천국_DP {
    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        int answer = 0;
        
        int[][] citiCount = new int[cityMap.length][cityMap[0].length];
        citiCount[0][0] = 1;
        
        for(int i=0; i<cityMap.length; i++){
            for(int j=0; j<cityMap[i].length; j++){                
                // 위쪽
                if(i-1 >= 0){
                    if(cityMap[i][j] == 1){
                        citiCount[i][j] = 0;
                    } else if(cityMap[i][j] == 2){
                        citiCount[i][j] = -1;
                    } else {
                        int index = i-1;
                        while(index > 0 && cityMap[index][j] == 2){
                            index--;
                        }
                        if(cityMap[index][j] != 1 && cityMap[index][j] != 2) {
                            citiCount[i][j] += citiCount[index][j] % MOD;
                        }
                    }
                }
                                
                // 왼쪽
                if(j-1 >= 0){
                    if(cityMap[i][j] == 1){
                        citiCount[i][j] = 0;
                    } else if(cityMap[i][j] == 2){
                        citiCount[i][j] = -1;
                    } else {
                        int index = j-1;
                        while(index > 0 && cityMap[i][index] == 2){
                            index--;
                        }
                        if(cityMap[i][index] != 1 && cityMap[i][index] != 2) {
                            citiCount[i][j] += citiCount[i][index] % MOD;
                        }
                    }
                }
                
            }
        }
        
//         // 출력해보기
//         for(int i=0; i<cityMap.length; i++){
//             for(int j=0; j<cityMap[i].length; j++){                
//                 System.out.print(cityMap[i][j] + " ");
//             }
//             System.out.println();
//         }
        
//         System.out.println();
        
//         // 출력해보기
//         for(int i=0; i<cityMap.length; i++){
//             for(int j=0; j<cityMap[i].length; j++){                
//                 System.out.print(citiCount[i][j] + " ");
//             }
//             System.out.println();
//         }
        
        answer = citiCount[cityMap.length-1][cityMap[0].length-1];
        return answer % MOD;
    }
}