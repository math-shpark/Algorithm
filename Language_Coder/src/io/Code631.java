package io;

import java.util.Scanner;

public class Code631 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		while (true) {
			double round = scan.nextDouble();

			if (round == 0)
				break;

			double radius = round / (2 * 3.14);
			System.out.printf("%.2f\n", radius);
		}
	}

}
