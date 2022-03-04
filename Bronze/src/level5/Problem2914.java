package level5;

import java.util.Scanner;

public class Problem2914 {

	// 2914. 저작권
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int A = scan.nextInt();
		int I = scan.nextInt();

		System.out.println(A * (I - 1) + 1);

		scan.close();
	}

}
