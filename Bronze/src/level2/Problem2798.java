package level2;

import java.util.Scanner;

public class Problem2798 {

	// 2798. 블랙잭
	public static void main(String[] args) {

		// Scanner 생성
		Scanner scan = new Scanner(System.in);

		// 카드 개수
		int N = scan.nextInt();
		// 사회자가 부를 숫자
		int M = scan.nextInt();
		// 카드 정보를 저장할 배열
		int[] cards = new int[N];
		// 최대 합을 저장할 변수
		int maxSum = 0;

		// 카드 정보를 배열에 저장하는 반복문
		for (int i = 0; i < N; i++) {
			cards[i] = scan.nextInt();
		}

		// 차례대로 3장씩 뽑은 후
		// 뽑은 카드의 합이 maxSum보다 크고 M보다 작으면 maxSum의 현재 값 대체
		for (int i = 0; i < N - 2; i++) {
			for (int j = i + 1; j < N - 1; j++) {
				for (int k = j + 1; k < N; k++) {
					int temp = cards[i] + cards[j] + cards[k];

					if (maxSum < temp && temp <= M) {
						maxSum = temp;
					}
				}
			}
		}

		// 결과 출력
		System.out.println(maxSum);

		// Scanner 종료
		scan.close();

	}

}
