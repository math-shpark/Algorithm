package list1;

public class SelectionAlgorithm {

	public static void main(String[] args) {

		int[] arr = { 13, 39, 29, 58, 93, 19, 0, 2, 5, 32, 56, 3 };

		for (int i = 0; i < 5; i++) {

			int minIndex = i;

			for (int j = i + 1; j < arr.length; j++) {
				if (arr[minIndex] > arr[j]) {
					minIndex = j;
				}
			}

			int temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;

			if (i == 4) {
				System.out.println(arr[4]);
			}

		}

	}

}
