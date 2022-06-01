package loop;

import java.util.Scanner;

public class Code129 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.print("Base = ");
			double base = scan.nextDouble();

			System.out.print("Height = ");
			double height = scan.nextDouble();

			System.out.printf("%s = %.1f\n", "Triangle width", base * height * 0.5);

			System.out.print("Continue? ");
			char command = scan.next().charAt(0);

			if (command == 'Y' || command == 'y')
				continue;
			else
				break;
		}
	}

}
