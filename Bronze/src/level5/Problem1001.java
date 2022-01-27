package level5;

import java.util.Scanner;

public class Problem1001 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("뺄 숫자를 입력하세요");

		int num1 = scan.nextInt();
		int num2 = scan.nextInt();

		System.out.println("뺀 결과 : " + (num1 - num2));

		scan.close();
	}

}
