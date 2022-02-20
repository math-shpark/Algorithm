package list2;

import java.util.Arrays;

public class SequentialSearch2 {

	public static void main(String[] args) {

		int[] arr = { 2, 3, 5, 8, 6, 7, 9, 2, 1, 0 };

		Arrays.sort(arr);
		int key = 3;
//		int key = 4;
		int result = -2;

		for (int i = 0; i < arr.length; i++) {
			if (key == arr[i]) {
				result = i;
				break;
			} else {
				result = -1;
			}
		}

		System.out.println(result);

	}

}
