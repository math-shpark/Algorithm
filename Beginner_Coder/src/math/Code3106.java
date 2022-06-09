package math;

import java.util.Scanner;

public class Code3106 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		for (int t = 0; t <= 100; t++) {
			int st = scan.nextInt(); // start

			if (st == 0)
				break; // finish

			String num = scan.next(); // number

			int ed = scan.nextInt(); // end

			String[] arr = num.split("");
			long de = 0; // decimal

			for (int i = 0; i < arr.length; i++) {
				if (arr[i].equals("0"))
					continue; // backtracking

				int pow = arr.length - i - 1; // power
				long add = (long) Math.pow(st, pow); // add number

				if (arr[i].charAt(0) >= 'A')
					add *= (int) (arr[i].charAt(0) - 'A') + 10; // 16
				else
					add *= Integer.parseInt(arr[i]); // 2, 8

				de += add;
			} // start -> decimal

			System.out.println(de);

			String result = "";

			while (de >= ed) {
				if (de % ed >= 10) {
					char input = (char) ('A' + (de % ed - 10)); // A ~
					result = input + result;
				} else
					result = de % ed + result;

				de /= ed;
			}

			if (de >= 10) {
				char last = (char) ('A' + de - 10);
				result = last + result;
			} else
				result = de + result;

			System.out.println(result); // print
		}
	}

}
