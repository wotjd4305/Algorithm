package TextBook;

import java.util.Arrays;

public class LIS_2 {
    public static void main(String args[]) {
       int[] a = {8,2,4,3,6,11,7,10,14,5};
       int[] C = new int[a.length];//index를 저장하자!
        int[] path = new int[a.length];//경로를 역추적할 index를 저장
       int size = 0;

       path[size] = -1; //첫번째 숫자라는 의미
       C[size++] = 0;//첫번쨰 숫자의 index 바로반영

        for(int i=1; i<a.length; i++){
            //C배열의 마지막 숫자의 수열값을 비교
            if(a[C[size-1]] < a[i]) {//마지막위치
                path[i] = C[size-1];
                C[size++] = i;//맨뒤에다가 붙인다
            }else{//LIS 마지막 숫자보다 크지않으면 LIS의 값을 업데이트
                //키값을 찾아주고 찾은 위치 인덱스(인트)리턴
                //int temp = Arrays.binarySearch(a,0,size,a[i]);//삽입위치음수
                int temp = binarySearch0(a, C,0,size,a[i]);//삽입위치음수
                if(temp < 0) temp = -temp -1;
                path[i] = path[C[temp]]; //덮어쓸 위치의 index를 내껄로 복사
                C[temp] = i; //수열의 값을 LIS 삽입할 위치에 덮어쓰기
            }
        }

        System.out.println(Arrays.toString(C) + " : C");
        System.out.println("LIS의 개수 : " + size);
        String result = "";
        for(int i =C[size-1]; i != -1; i=path[i])
            result = a[i] +" " +result;

        System.out.println("LIS 수얼 : " + result);


    }

    public static int binarySearch0(int a[], int[] C, int fromIndex, int toIndex,
                                     int key) {
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = a[C[mid]];

            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1);  // key not found.
    }
}
