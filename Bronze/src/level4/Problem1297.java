package level4;

import java.util.Scanner;

public class Problem1297 {

	// 1297. TV 크기
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		double D = scan.nextDouble();
		double H = scan.nextDouble();
		double W = scan.nextDouble();

		double x = Math.sqrt((D * D) / (H * H + W * W));

		System.out.println((int) (H * x) + " " + (int) (W * x));
		
		scan.close();

	}

}
