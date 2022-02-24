package level1;

import java.util.Scanner;

public class Problem11050 {

	// 11050. 이항 계수 1
	public static void main(String[] args) {

		// Scanner 생성
		Scanner scan = new Scanner(System.in);

		// 이항계수 원소 입력
		int N = scan.nextInt();
		int K = scan.nextInt();

		// K가 0이면 N과 관계없이 1
		if (K == 0) {
			System.out.println(1);
		} else {
			// K가 0이 아니면
			// 분자
			int num = 1;
			// 분모
			int den = 1;

			// 이항계수의 분모와 분자를 구하는 반복문
			for (int i = 0; i < K; i++) {
				num *= (N - i);
				den *= (K - i);
			}

			// 결과 출력
			System.out.println(num / den);

		}

		// Scanner 종료
		scan.close();

	}

}
