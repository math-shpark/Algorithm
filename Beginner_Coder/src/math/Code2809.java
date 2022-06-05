package math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Code2809 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int N = scan.nextInt();
		List<Integer> list = new ArrayList<>();
		int range = (int) Math.sqrt(N) + 1;

		for (int i = 1; i <= range; i++) {
			if (N % i == 0) {
				if (!list.contains(i)) {
					list.add(i);
					if (!list.contains(N / i))
						list.add(N / i);
				}
			}
		}

		Collections.sort(list);

		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i));
			if (i != list.size() - 1)
				System.out.print(" ");
		}
	}

}
