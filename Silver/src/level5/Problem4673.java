package level5;

public class Problem4673 {

	// 4673. 셀프 넘버
	public static void main(String[] args) {

		// 1부터 10000까지 숫자의 배열
		int[] arr = new int[10000];

		// 수열로 만들어지는 수는 셀프 넘버가 아님
		// 수열로 만들어지는 수에 대한 배열 칸에 1 대입하는 반복문
		for (int i = 1; i <= 10000; i++) {
			int j = i;

			while (j <= 10000) {

				String str = String.valueOf(j);
				String[] arr2 = str.split("");

				for (int k = 0; k < arr2.length; k++) {
					j += Integer.parseInt(arr2[k]);
				}

				if (j - 1 < 10000) {
					arr[j - 1] = 1;
				}

			}
		}

		for (int i = 0; i < 10000; i++) {
			if (arr[i] != 1) {
				System.out.println(i + 1);
			}
		}

	}

}
