package level3;

import java.util.Scanner;

public class Problem10950 {

	// 10950. A+B (3)
	public static void main(String[] args) {

		// Scanner 생성
		Scanner scan = new Scanner(System.in);

		// 테스트 케이스 입력
		int testCase = scan.nextInt();
		// 결과값 저장 배열 생성
		int[] resultSet = new int[testCase];

		// 각 테스트 케이스별 결과를 배열에 저장하는 반복문
		for (int i = 0; i < testCase; i++) {
			int num1 = scan.nextInt();
			int num2 = scan.nextInt();

			resultSet[i] = num1 + num2;
		}

		// 결과 출력
		for (int i = 0; i < testCase; i++) {
			System.out.println(resultSet[i]);
		}

		// Scanner 종료
		scan.close();

	}

}
