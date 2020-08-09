package Algo.src;

//콜트리 찍어서 올리세요
public class Z33_순열 {
	public static int[] arr = {6,7,8};
	static int n;
	
	public static void main(String args[]) {
		n = arr.length;
		int r = 3; //4개중에 4개
		perm(r,0); //0은 스택, 0이 n까지 반복
		
	}

	//r은 뽑을 갯수, k는 현재 단계
	private static void perm(int r, int k) {
		if(r == k) { //종료 파트
			for(int i =0; i<r; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		} else { //재귀 파트, 원복이 중요
			for(int i = k; i<arr.length; i++) {// 0~(k-1) = 확정, k~끝까지 = 미선택. k번째 숫자 결정하기
				//arr[i]번째 <-> arr[k]번쨰 스왑
				int temp = arr[k];
				arr[k] = arr[i];
				arr[i] = temp;
				perm(r,k+1);
				
				//arr[i] <-> arr[k] 스왑, 다음 작업을 위해서
				temp = arr[k];
				arr[k] = arr[i];
				arr[i] = temp;
				
			}
			
		}
		
	}

}
