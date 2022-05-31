package debug;

import java.util.Scanner;

public class Code527 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int num1, num2;

		// 숫자 입력
		num1 = scan.nextInt();
		num2 = scan.nextInt();

		// 출력 양식에 맞춰 출력
		System.out.printf("%d %.2f", num1 / num2, (double) num1 / num2);

	}

}
