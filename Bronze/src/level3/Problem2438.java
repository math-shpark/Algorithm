package level3;

import java.util.Scanner;

public class Problem2438 {

	// 2438. 별 찍기 - 1
	public static void main(String[] args) {

		// Scanner 생성
		Scanner scan = new Scanner(System.in);

		// 별의 개수 입력
		int count = scan.nextInt();

		// 행의 개수만큼 별을 출력하는 반복문
		for (int i = 1; i <= count; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}

			System.out.println(); // 다음 줄로 넘김
		}

		// 종료
		scan.close();
	}

}
