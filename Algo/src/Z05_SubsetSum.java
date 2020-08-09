package Algo.src;

/* Subset : 부분집합
 * PowerSet(멱집합): 어떤 집합의 모든 부분집합을 원소로 갖는 집합 
 * 		노가다
 * 		바이너리카운팅
 * 		재귀함수
 * 
 * */
public class Z05_SubsetSum {
	public static void main(String[] args) {
		int[] a = { -7, -3, -2, 5, 8 };

		for (int i = 0; i < 2; i++) { // 첫번째 원소를 사용할 변수 //0이면 씀 1이면 안씀
			for (int j = 0; j < 2; j++) {
				for (int j2 = 0; j2 < 2; j2++) {
					for (int k = 0; k < 2; k++) {
						for (int k2 = 0; k2 < 2; k2++) {
							int sum = 0;
							if (i == 1) sum += a[0];
							if (j == 1) sum += a[1];
							if (j2 == 1) sum += a[2];
							if (k == 1) sum += a[3];
							if (k2 == 1) sum += a[4];
							
							if (sum == 0) {
								System.out.println("합 : " + sum);
								if (i == 1) System.out.print(a[0] + " ");
								if (j == 1) System.out.print(a[1] + " ");
								if (j2 == 1) System.out.print(a[2] + " ");
								if (k == 1) System.out.print(a[3] + " ");
								if (k2 == 1) System.out.print(a[4] + " ");
								System.out.println();
							}

						}
					}
				}
			}
		}
	}
}
