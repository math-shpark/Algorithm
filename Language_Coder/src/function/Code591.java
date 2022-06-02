package function;

import java.util.Scanner;

public class Code591 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();

		int[] arr = new int[n + 1];
		arr[1] = 1;

		for (int i = 2; i <= n; i++) {
			arr[i] = arr[i - 1] + arr[i / 2];
		}

		System.out.println(arr[n]);
	}

}
