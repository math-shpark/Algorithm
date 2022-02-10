package level5;

import java.util.Scanner;

public class Problem10869 {

	// 10869. 사칙연산
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int A = scan.nextInt();
		int B = scan.nextInt();

		System.out.println(A + B);
		System.out.println(A - B);
		System.out.println(A * B);
		System.out.println(A / B);
		System.out.println(A % B);

		scan.close();

	}

}
