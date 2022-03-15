package level3;

import java.util.Scanner;

public class Problem11047 {

	// 11047. 동전 0
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// 동전 개수 입력
		int N = scan.nextInt();
		// 목표 금액 입력
		int K = scan.nextInt();

		// 동전별 금액 배열
		int[] values = new int[N];

		// 동전별 금액 저장
		for (int i = 0; i < N; i++) {
			values[i] = scan.nextInt();
		}

		// 동전 개수
		int count = 0;

		// 큰 금액부터 몫을 동전 개수에 더하고
		// K에 해당 금액만큼 차감
		for (int i = N - 1; i >= 0; i--) {
			int q = (K / values[i]);
			count += q;
			K -= q * values[i];
		}

		// 결과 출력
		System.out.println(count);

		scan.close();

	}

}
