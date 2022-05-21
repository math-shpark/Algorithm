package level5;

import java.util.Scanner;

public class Problem10430 {

	// 10430. 나머지
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int A = scan.nextInt();
		int B = scan.nextInt();
		int C = scan.nextInt();

		System.out.println((A + B) % C);
		System.out.println(((A % C) + (B % C)) % C);
		System.out.println((A * B) % C);
		System.out.println(((A % C) * (B % C)) % C);
		
		scan.close();

	}

}
