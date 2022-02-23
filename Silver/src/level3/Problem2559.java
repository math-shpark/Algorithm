package level3;

import java.util.Scanner;

public class Problem2559 {

	// 2559. 수열
	public static void main(String[] args) {

		// Scanner 생성
		Scanner scan = new Scanner(System.in);

		// 수열 개수 입력
		int N = scan.nextInt();
		// 연속 일수 입력
		int K = scan.nextInt();
		// 온도 정보를 저장할 배열
		int[] temperature = new int[N];
		// 최대 합을 저장할 변수
		int maxSum = -10000000;

		// 온도 정보를 배열에 저장
		for (int i = 0; i < N; i++) {
			temperature[i] = scan.nextInt();
		}

		// 정해진 일수만큼 더한 후 최대 합인지 판별하는 반복문
		for (int i = 0; i <= N - K; i++) {
			int temp = 0;

			for (int j = 0; j < K; j++) {
				temp += temperature[i + j];
			}

			if (maxSum < temp) {
				maxSum = temp;
			}
		}

		// 결과 출력
		System.out.println(maxSum);

		// Scanner 종료
		scan.close();

	}

}
