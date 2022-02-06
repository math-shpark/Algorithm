package level3;

import java.util.Scanner;

public class Problem2739 {

	// 2739. 구구단
	public static void main(String[] args) {

		// Scanner 생성
		Scanner scan = new Scanner(System.in);

		// 구구단할 숫자 입력값 저장
		int num = scan.nextInt();

		// 구구단 결과 출력 반복문
		for (int i = 1; i < 10; i++) {
			System.out.println(num + " * " + i + " = " + (num * i));
		}

		scan.close();

	}

}
