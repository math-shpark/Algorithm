package list2;

public class CountingSort {

	public static void main(String[] args) {

		int[] arr = { 0, 4, 1, 3, 1, 2, 4, 1 };
		int[] count;
		int maxVal = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > maxVal) {
				maxVal = arr[i];
			}
		}

		count = new int[maxVal + 1];

		for (int i = 0; i < arr.length; i++) {
			count[arr[i]]++;
		}

		for (int i = 1; i < count.length; i++) {
			count[i] += count[i - 1];
		}

		int[] arrSorted = new int[arr.length];

		for (int i = arr.length - 1; i >= 0; i--) {

			arrSorted[count[arr[i]] - 1] = arr[i];
			count[arr[i]]--;

		}

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arrSorted[i] + " ");
		}

	}

}
