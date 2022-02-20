package list2;

import java.util.Arrays;

public class BinarySearch {

	public static void main(String[] args) {

		int[] arr = { 20, 39, 19, 100, 38, 29, 48, 57, 37, 85, 82, 47, 52, 56 };
		int key = 29;
//		int key = 28;

		Arrays.sort(arr);

		int start = 0;
		int end = arr.length - 1;
		int middle;

		while (true) {

			if (start > end) {
				middle = -1;
				break;
			}

			middle = (start + end) / 2;

			if (arr[middle] == key) {
				break;
			} else if (arr[middle] < key) {
				start = middle + 1;
			} else {
				end = middle - 1;
			}
		}

		System.out.println(middle);
	}

}
