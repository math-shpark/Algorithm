package function;

import java.util.Scanner;

public class Code181 {

	public static void main(String[] args) {
		double pi = 3.141592;
		System.out.print("radius : ");

		Scanner scan = new Scanner(System.in);

		double r = scan.nextDouble();

		System.out.printf("area = %.3f", pi * r * r);
	}

}
