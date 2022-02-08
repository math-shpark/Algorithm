package level2;

import java.util.Scanner;

public class Problem10809 {

	// 10809. 알파벳 찾기
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int[] arr = new int[26];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = -1;
		}

		String str = scan.next();

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			if (arr[ch - 'a'] == -1) {
				arr[ch - 'a'] = i;
			}
		}

		for (int point : arr) {
			System.out.print(point + " ");
		}

		scan.close();

	}

}
