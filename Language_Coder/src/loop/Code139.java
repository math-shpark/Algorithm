package loop;

import java.util.Scanner;

public class Code139 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int num1, num2;
		num1 = sc.nextInt();
		num2 = sc.nextInt();

		int dif = num1 < num2 ? 1 : -1;

		for (int i = 1; i <= 9; i++) {
			if (num1 <= num2) {
				for (int j = num1; j <= num2; j++) {
					if (j != num1)
						System.out.print("   ");
					System.out.print(j + " * " + i + " =");
					if (j * i < 10)
						System.out.print("  ");
					else
						System.out.print(" ");
					System.out.print(j * i);
				}
			} else {
				for (int j = num1; j >= num2; j--) {
					if (j != num1)
						System.out.print("   ");
					System.out.print(j + " * " + i + " =");
					if (j * i < 10)
						System.out.print("  ");
					else
						System.out.print(" ");
					System.out.print(j * i);
				}
			}
			System.out.println();
		}

	}

}
