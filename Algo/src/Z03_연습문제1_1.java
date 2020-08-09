package Algo.src;

public class Z03_연습문제1_1 {
	public static void main(String[] args) {

		int[][] map = new int[7][7];
		int tmp = 0;
		int result = 0;
		int[][] ptr = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
		
		for (int x = 0; x < 7; x++) {
			for (int y = 0; y < 7; y++) {
				if ((x > 0 && x < 6) && (y > 0 && y < 6))
					map[x][y] = 5 * (x - 1) + y - 1;
				else
					map[x][y] = -1;
			}
		}

		for (int x = 1; x <= 5; x++) {
			for (int y = 1; y <= 5; y++) {
				tmp = 0;
				for (int i = 0; i < 4; i++) { // 4방위 계산
					if (map[x + ptr[i][0]][y + ptr[i][1]] != -1)
						tmp += Math.abs(map[x + ptr[i][0]][y + ptr[i][1]] - map[x][y]);
				}
				result += tmp;
			}
		}
		System.out.println("result : " + result);
	}
}
