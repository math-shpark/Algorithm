package math;

import java.util.Arrays;
import java.util.Scanner;

public class Code2813 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int m = scan.nextInt(); // M
		int n = scan.nextInt(); // N

		boolean[] map = new boolean[n + 1]; // data

		Arrays.fill(map, true); // init

		map[0] = false;
		map[1] = false;

		for (int i = 2; i <= n; i++) {
			if (!map[i])
				continue;
			
			int multi = 2;
			while (i * multi <= n) {
				map[i * multi] = false;
				multi++;
			}
		}

		int count = 0;
		for (int i = m; i <= n; i++) {
			if (map[i])
				count++;
		}

		System.out.println(count);

	}

}
