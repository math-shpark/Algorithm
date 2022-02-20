package list2;

public class SequentialSearch1 {

	public static void main(String[] args) {

		int[] arr = { 2, 3, 5, 8, 6, 7, 9, 2, 1, 0 };
		int key = 3;
//		int key = 4;
		int result = -2;

		for (int i = 0; i < arr.length; i++) {
			if (key == arr[i]) {
				result = i;
			} else if (result == -2 && i == arr.length - 1) {
				result = -1;
			}
		}

		System.out.println(result);

	}

}
