package level3;

import java.util.Scanner;

public class Problem10952 {

	// 10952. A + B (5)
	public static void main(String[] args) {

		// Scanner 생성
		Scanner scan = new Scanner(System.in);

		// 0 입력할 때까지 무한 반복
		while (true) {

			// 더할 수 입력
			int A = scan.nextInt();
			int B = scan.nextInt();

			// 입력값이 0이면 반복문 종료
			if (A == 0) {
				break;
			}

			// 아니면 덧셈 결과 출력
			System.out.println(A + B);
		}

		// Scanner 종료
		scan.close();

	}

}
