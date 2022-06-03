package figure;

import java.util.Scanner;

public class Code1291 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int s, e;
		while (true) {
			s = scan.nextInt();
			e = scan.nextInt();
			if (s < 2 || s > 9 || e < 2 || e > 9) {
				System.out.println("INPUT ERROR!");
				continue;
			} else
				break;
		}
		
		int add = s <= e ? 1 : -1;

		for (int i = 1; i <= 9; i++) {
			for (int j = s; s <= e ? j <= e : j >= e; j += add) {
				System.out.print(j + " * " + i + " =");
				if (j * i < 10)
					System.out.print("  " + j * i);
				else
					System.out.print(" " + j * i);
				
				if(j != e)
					System.out.print("   ");
				else
					System.out.println();
			}
		}
	}

}
