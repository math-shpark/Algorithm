package level4;

import java.util.Scanner;

public class Problem1008 {

	// 1008. A/B
	public static void main(String[] args) {

		// Scanner 생성
		Scanner scan = new Scanner(System.in);

		// 입력값을 double로 받음
		double num1 = scan.nextDouble();
		// 두 번째 입력값은 int 또는 double로 받음
		int num2 = scan.nextInt();

		// 결과값을 double 타입으로 저장
		double result = num1 / num2;

		// 결과 출력
		System.out.println(result);

		// 끝내기
		scan.close();

	}

}
