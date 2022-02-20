package list1;

public class BubbleSort {

	public static void main(String[] args) {

		int[] arr = { 13, 42, 12, 0, 39, 28, 23, 48, 13 };

		// 오름차순 정렬
		for (int i = arr.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}

		// 정렬 결과 출력
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("%d\t", arr[i]);
		}

	}

}