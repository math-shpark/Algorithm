package level4;

import java.util.Scanner;

public class Problem1330 {

	// 1330. 두 수 비교하기
	public static void main(String[] args) {

		// Scanner 생성
		Scanner scan = new Scanner(System.in);

		// 입력 숫자 2개 받기
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();

		// 숫자 크기 비교 결과에 따라 출력값 설정
		if (num1 < num2) {
			System.out.println("<");
		} else if (num1 > num2) {
			System.out.println(">");
		} else {
			System.out.println("==");
		}

		// 종료
		scan.close();

	}

}
