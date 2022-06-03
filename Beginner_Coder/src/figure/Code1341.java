package figure;

import java.util.Scanner;

public class Code1341 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int s, e;
		s = scan.nextInt();
		e = scan.nextInt();

		int idx = s;
		int add = s <= e ? 1 : -1;

		while (s <= e ? idx <= e : idx >= e) {
			for (int i = 1; i < 10; i += 3) {
				for (int j = i; j < i + 3; j++) {
					System.out.print(idx + " * " + j + " =");
					if (idx * j < 10)
						System.out.print("  " + idx * j);
					else
						System.out.print(" " + idx * j);

					if (j != i + 2)
						System.out.print("   ");
					else
						System.out.println();
				}
			}
			System.out.println();
			idx += add;
		}
	}

}
