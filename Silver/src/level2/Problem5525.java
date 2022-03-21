package level2;

import java.util.Scanner;

public class Problem5525 {

	// 5525. IOIOI
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// 찾을 문자열 길이 입력
		int N = scan.nextInt();
		// 대상 문자열 길이 입력
		int M = scan.nextInt();

		// 입력받은 문자열을 배열로 변환
		char[] sentence = scan.next().toCharArray();

		// 찾을 문자열의 개수
		int count = 0;
		// IOI의 개수
		int partCount = 0;

		for (int i = 1; i < M - 1; i++) {
			// IOI를 찾으면
			if (sentence[i - 1] == 'I' && sentence[i] == 'O' && sentence[i + 1] == 'I') {
				// IOI 개수를 추가하고
				partCount++;
				// 지금까지 센 IOI개수가 원하는 길이이면
				if (partCount == N) {
					// IOI 개수를 1 차감하고
					partCount--;
					// 결과 개수에 1 추가
					count++;
				}
				// 2칸 이동을 위해 i를 1 더함
				i++;
			} else {
				// 만족하지 않으면 초기화
				partCount = 0;
			}
		}
		// 결과 출력
		System.out.println(count);

		scan.close();

	}

}
