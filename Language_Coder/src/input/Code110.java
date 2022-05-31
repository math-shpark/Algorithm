package input;

import java.util.Scanner;

public class Code110 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.print("yard? ");

		double yard = scan.nextDouble();

		System.out.printf("%.1fyard = %.1fcm", yard, yard * 91.44);
	}

}
