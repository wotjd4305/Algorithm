package main.java.Temp2021_1.단순반복;


import java.util.Scanner;

class 이진탐색 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[] Arr = { 10, 20, 30, 35, 40 };

        System.out.println(BinarySearch(Arr, 10));
    }

    public static int BinarySearch(int arr[], int findNum) {

        int result = 0;

        int left = 0;
        int right = arr.length-1;
        int mid;

        while(left<=right) {
            mid =(left + right)/2;
            System.out.println("도냐");
            if (findNum > arr[mid]) {
                left = mid + 1;
            }
            if (findNum < arr[mid]) {
                right = mid - 1;
            }
            if(findNum == arr[mid]){
                System.out.println("위치 인덱스 : " + mid);
                System.out.println("위치 값 : " + arr[mid]);
                result = mid;
                break;
            }
        }

        return result;
    }




//    int start = 0;
//    int end = arr.length - 1;
//    int mid;
//    int result = -1;
//
//        while (start <= end) {
//        mid = (start + end) / 2;
//
//        if (arr[mid] == findNum) {
//            result = mid;
//            break;
//        }
//        if (arr[mid] > findNum) {
//            end = mid - 1;
//        } else {
//            start = mid + 1;
//        }
//    }

}