package level1;

import java.util.Scanner;

public class Problem4344 {

	// 4344. 평균은 넘겠지
	public static void main(String[] args) {

		// Scanner 생성
		Scanner scan = new Scanner(System.in);

		// 테스트 케이스 개수 입력
		int testCaseNum = scan.nextInt();

		// 입력한 테스트 케이스 개수만큼 반복
		for (int i = 0; i < testCaseNum; i++) {
			// 학생 수
			int stdNum = scan.nextInt();
			// 학생별 점수 저장 배열
			double[] scores = new double[stdNum];
			// 점수 총합 저장 변수
			double sum = 0;

			// 점수를 배열에 저장하고
			// 총합에 더하는 반복문
			for (int j = 0; j < stdNum; j++) {
				scores[j] = scan.nextInt();
				sum += scores[j];
			}

			// 평균 계산
			double avg = sum / stdNum;
			// 평균보다 높은 학생 수를 저장하는 변수
			int countStd = 0;

			// 평균보다 높은 학생 수를 세는 반복문
			for (int j = 0; j < scores.length; j++) {
				if (scores[j] > avg) {
					countStd++;
				}
			}

			// 비율 계산
			double ratio = (double) countStd / stdNum * 100;

			// 출력 양식에 맞춰 출력
			System.out.printf("%.3f%%\n", ratio);

		}

		// Scanner 종료
		scan.close();

	}

}
