package level3;

import java.util.Scanner;

public class Problem10951 {

	// 10951. A+B (4)
	public static void main(String[] args) {

		// Scanner 생성
		Scanner scan = new Scanner(System.in);

		// 입력한 값이 있으면 더한 후 출력하는 반복문
		while (scan.hasNextInt()) {
			int num1 = scan.nextInt();
			int num2 = scan.nextInt();

			System.out.println(num1 + num2);
		}

	}

}
