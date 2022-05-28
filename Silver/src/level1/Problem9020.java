package level1;

import java.util.Scanner;

public class Problem9020 {

	// 9020. 골드바흐의 추측
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int T = scan.nextInt(); // 테스트 케이스 수

		for (int test = 0; test < T; test++) {
			int num = scan.nextInt(); // 찾을 수

			int part1 = num / 2;
			int part2 = num - part1;

			while (!checkNum(part1) || !checkNum(part2)) {
				part1--;
				part2++;
			}

			System.out.println(part1 + " " + part2);
		}

	}

	private static boolean checkNum(int num) {
		
		int count = 0;
		for (int i = 1; i <= Math.sqrt(num); i++) {
			if(num % i == 0) {
				count++;
			}
		}
		
		return count == 1;
	}

}
