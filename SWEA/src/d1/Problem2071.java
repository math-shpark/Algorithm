package d1;

import java.util.Scanner;

public class Problem2071 {

	// 2071. 평균값 구하기
	public static void main(String[] args) {

		// Scanner 생성
		Scanner scan = new Scanner(System.in);

		// 테스트 케이스 입력받아 저장
		int testCaseNum = scan.nextInt();
		// 테스트 케이스별 결과를 저장할 배열 생성
		int[] resultSet = new int[testCaseNum];

		// 테스트 케이스별 평균을 구하는 반복문
		for (int testCase = 0; testCase < testCaseNum; testCase++) {

			// 합을 저장할 변수 생성
			int sum = 0;

			// 입력한 값을 합 변수에 더하는 반복문
			for (int i = 0; i < 10; i++) {
				sum += scan.nextInt();
			}

			// 평균 계산
			double avg = (double) sum / 10;

			// 소수 첫째 자리에서 반올림한 결과를 배열에 저장
			resultSet[testCase] = (int) Math.round(avg);
		}

		// 출력 양식에 맞춰 출력
		for (int testCase = 1; testCase <= testCaseNum; testCase++) {
			System.out.println("#" + testCase + " " + resultSet[testCase - 1]);
		}

		// Scanner 종료
		scan.close();

	}

}
