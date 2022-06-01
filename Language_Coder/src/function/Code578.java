package function;

import java.util.Scanner;

public class Code578 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int num1, num2;
		num1 = scan.nextInt();
		num2 = scan.nextInt();

		if (num1 >= num2) {
			int temp = num1;
			num1 = num2;
			num2 = temp;
		}

		for (int i = num1; i <= num2; i++) {
			System.out.println("== " + i + "dan ==");
			for (int j = 1; j <= 9; j++) {
				System.out.print(i + " * " + j + " =");
				if (i * j < 10)
					System.out.println("  " + i * j);
				else
					System.out.println(" " + i * j);
			}
		}
	}

}
