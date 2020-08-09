package Algo.src;

public class Z03_연습문제1 {
	public static void main(String[] args) {

		int result = 0;

		for (int x = 0; x < 5; x++) {
			for (int y = 0; y < 5; y++) {
				if (x - 1 >= 0) result += Math.abs(5);
				if (x + 1 <= 4) result += Math.abs(5);
				if (y - 1 >= 0) result += Math.abs(1);
				if (y + 1 <= 4) result += Math.abs(1); // (5 * x + (y+1))- (5 * x + y)
			}
		}

		System.out.println("result : " + result);
	}
}
