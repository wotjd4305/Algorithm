package exam.naver;

import java.util.LinkedList;

public class Solution1 {
    public static void main(String[] args) {
/*        int [] arrA = {7, 8, 10};
        int [] arrB = {10, 7, 8};*/

        int [] arrA = {1, 1, 1,1};
        int [] arrB = {1, 1, 1, 1};

        //int [] arrA = {1, 1, 4, 3,3};
        //int [] arrB = {4, 3, 3, 1, 1};



        System.out.println(solution(arrA, arrB));
    }


    public static boolean solution(int[] arrA, int[] arrB) {
        int checkCorrect = 0;
        int checkCount=0;

        LinkedList<Integer> listA = new LinkedList<>();

        for(int a : arrA){
            listA.add(a);
        }

        if(arrA.length != arrB.length){
            return false;
        }

        while(checkCount!=arrA.length){

            System.out.println(listA);
            for(int i=0; i<listA.size(); i++){
                if(listA.get(i)==arrB[i]) {
                    checkCorrect++;
                }
            }
            if(checkCorrect==arrA.length){
                return true;
            }
            listA.addFirst(listA.removeLast());   //마지막 값을 앞으로 넣음

            checkCount++;
            checkCorrect=0;
        }
        return false;
    }
}