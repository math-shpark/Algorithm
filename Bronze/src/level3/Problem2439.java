package level3;

import java.util.Scanner;

public class Problem2439 {

	// 2439. 별 찍기 - 2
	public static void main(String[] args) {

		// Scanner 생성
		Scanner scan = new Scanner(System.in);

		// 별의 개수 입력
		int count = scan.nextInt();

		// 공백 출력 후 별을 출력하는 반복문
		for (int i = 1; i <= count; i++) {

			for (int j = 1; j <= count - i; j++) {
				System.out.print(" ");
			}

			for (int k = 1; k <= i; k++) {
				System.out.print("*");
			}

			System.out.println("");
		}

		scan.close();

	}

}
