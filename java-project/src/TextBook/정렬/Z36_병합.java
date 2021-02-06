package TextBook.정렬;

import java.io.IOException;
import java.util.Arrays;

//반복문
public class Z36_병합 {

	public static int[] arr = {6,4,8,5,7,2,9,3,0,1};
	public static void main(String args[]) throws NumberFormatException, IOException {
	
		mergeSort(0, arr.length);//앞에꺼포함 뒤에꺼 미포함
		System.out.println(Arrays.toString(arr));	
	}

	//입력받은 배열의 left~right 덩이를 반으로 쪼개서 재귀호출, 최소 단위까지 쪼갠것을 합침.
	private static void mergeSort(int left, int right) {
		if (right - left <=1) {
			return;
		}
		int mid = (left + right)/2;
		mergeSort(left, mid);//왼쪽은 포함되고 미드는 미포함(약속해)
		mergeSort(mid, right);//미드는 포함되고 오른쪽은 미포함
		merge(left,mid,right);//mid를 중심으로 두영역을 합쳐라
		
		//쪼갤수있다면 내려왔을거야.
	}

	// 입력받은 배열의 left~right | mid ~rigth 합쳐
	private static void merge(int left, int mid, int right) {
		int[] temp = new int[right - left]; //정복하면서 저장할 임시배열
		int l = left;
		int r= right;
		int index = 0;
		
		//안쪽에서 작업을 다 끝내겠다.
		//둘다 남아있는 경우
		while(l<mid && r< right) {
			if(arr[l] < arr[r])
				temp[index++] = arr[l++];
			else
				temp[index++] = arr[r++];
		}
	//왼쪽만 남아있는 경우
		/*while(l < mid) {
			temp[index++] = arr[l++];
		}*/
		System.arraycopy(arr, l, temp, index, mid-l);
		
		//오른쪽만 남아있는 경우
		System.arraycopy(arr, r, temp, index, right-r);
		
		//임시배열을 temp원본배열에 붙여넣기
		System.arraycopy(temp,0,arr,left,right-left);
		
		
	}
	
}
