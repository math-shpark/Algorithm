package level1;

import java.util.Scanner;

public class Problem1402 {

	// 1402. 아무래도 이 문제는 A번 난이도인 것 같다
	public static void main(String[] args) {

		// Scanner 객체 생성
		Scanner scan = new Scanner(System.in);

		// 테스트 케이스 횟수 입력
		int testCaseNum = scan.nextInt();

		// 입력 값과 상관없이 결과는 항상 yes
		// 1과 -1을 적절히 곱하면 모든 정수로 변환 가능
		for (int i = 0; i < testCaseNum; i++) {
			int num1 = scan.nextInt(); // 사실상 사용 안함
			int num2 = scan.nextInt(); // 사실상 사용 안함

			// 입력과 무관하게 결과 출력
			System.out.println("yes");
		}

		// 끝내기
		scan.close();

	}

}
