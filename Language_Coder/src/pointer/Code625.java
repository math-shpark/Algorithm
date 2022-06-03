package pointer;

import java.util.Arrays;
import java.util.Scanner;

public class Code625 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		}
		
		Arrays.sort(arr);
		
		for (int i = n - 1; i >= 0; i--) {
			System.out.print(arr[i]);
			if(i != 0)
				System.out.print(" ");
		}
	}

}
