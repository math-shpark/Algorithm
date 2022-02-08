package level2;

import java.util.Scanner;

public class Problem2908 {

	// 2908. 상수
	public static void main(String[] args) {

		// Scanner 생성
		Scanner scan = new Scanner(System.in);

		// 두 수 입력
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();

		// 거꾸로 읽은 값 저장
		num1 = num1 / 100 + (num1 % 100) / 10 * 10 + (num1 % 10) * 100;
		num2 = num2 / 100 + (num2 % 100) / 10 * 10 + (num2 % 10) * 100;

		// 최댓값 출력
		System.out.println(Math.max(num1, num2));

		// 종료
		scan.close();

	}

}
