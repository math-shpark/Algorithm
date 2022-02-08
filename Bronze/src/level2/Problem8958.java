package level2;

import java.util.Scanner;

public class Problem8958 {

	// 8958. OX 퀴즈
	public static void main(String[] args) {

		// Scanner 생성
		Scanner scan = new Scanner(System.in);

		// testcase 입력
		int testCase = scan.nextInt();
		// 테스트 케이스별 점수를 저장할 배열
		int[] scoreArr = new int[testCase];

		for (int i = 0; i < testCase; i++) {
			// 입력받은 채점 결과를 하나씩 배열로 저장
			String[] result = scan.next().split("");
			// 문항 수에 맞춰 문항별 점수를 저장할 배열 생성
			int[] scores = new int[result.length];
			// 점수 총점을 저장할 변수
			int sum = 0;

			// 첫 문제에 대한 점수
			if (result[0].equals("O")) {
				scores[0] = 1;
			} else {
				scores[0] = 0;
			}

			// 두 번째 문제부터 마지막 문제에 대한 점수 저장하는 반복문
			for (int j = 1; j < result.length; j++) {
				if (result[j].equals("O")) {
					scores[j] = scores[j - 1] + 1;
				} else {
					scores[j] = 0;
				}
			}

			// 문항별 점수를 더하는 반복문
			for (int j = 0; j < scores.length; j++) {
				sum += scores[j];
			}

			// 테스트 케이스의 결과를 배열에 저장
			scoreArr[i] = sum;

		}

		// 테스트 케이스별 결과를 출력
		for (int i = 0; i < scoreArr.length; i++) {
			System.out.println(scoreArr[i]);
		}

		// 종료
		scan.close();

	}

}
