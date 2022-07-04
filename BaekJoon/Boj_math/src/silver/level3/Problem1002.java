package silver.level3;

import java.util.Scanner;

public class Problem1002 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int tc = scan.nextInt(); // test case

		for (int t = 0; t < tc; t++) {
			int[] arr = new int[6]; // data array

			for (int i = 0; i < 6; i++) {
				arr[i] = scan.nextInt();
			} // data input

			double d = Math.sqrt(Math.pow(arr[0] - arr[3], 2) + Math.pow(arr[1] - arr[4], 2)); // distance

			// Case 1. same location
			if (arr[0] == arr[3] && arr[1] == arr[4]) {
				if (arr[2] == arr[5]) {
					System.out.println(-1); // same location & same radius
					continue;
				} else {
					System.out.println(0); // same location & different radius
					continue;
				}
			} else { // Case 2. different location
				if (Math.min(arr[2], arr[5]) + d < Math.max(arr[2], arr[5])) {
					System.out.println(0); // one circle is in the other
					continue;
				} else if (Math.min(arr[2], arr[5]) + d == Math.max(arr[2], arr[5])) {
					System.out.println(1); // Two circles have one contact point
					continue;
				} else {
					if (d > arr[2] + arr[5]) {
						System.out.println(0); // Distance is longer than the sum of r1 and r2
						continue;
					}
					if (d == arr[2] + arr[5]) {
						System.out.println(1); // Two circles have one contact point
						continue;
					}
					if (d < arr[2] + arr[5]) {
						System.out.println(2); // Two circles have two contact point
					}
				}
			}
		}
	}

}
