package loop;

import java.util.Scanner;

public class Code633 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.println("1. Korea\r\n" + "2. USA\r\n" + "3. Japan\r\n" + "4. China");
			System.out.print("number? ");
			int command = scan.nextInt();
			System.out.println();

			switch (command) {
			case 1:
				System.out.println("Seoul");
				break;
			case 2:
				System.out.println("Washington");
				break;
			case 3:
				System.out.println("Tokyo");
				break;
			case 4:
				System.out.println("Beijing");
				break;
			default:
				System.out.println("none");
				return;
			}

			System.out.println();
		}
	}

}
