package sort;

import java.util.Arrays;
import java.util.Comparator;

public class Problem42746 {

	public static void main(String[] args) {
		int[] numbers = { 6, 10, 2 };

		String answer = solution(numbers);

		System.out.println(answer);
	}

	private static String solution(int[] numbers) {
		String answer = "";
		String[] arr = new String[numbers.length];

		for (int i = 0; i < arr.length; i++)
			arr[i] = Integer.toString(numbers[i]);

		Arrays.sort(arr, new Comparator<String>() {
			public int compare(String o1, String o2) {
				String sum1 = o1 + o2;
				String sum2 = o2 + o1;

				return sum2.compareTo(sum1);
			}
		});

		if (Integer.parseInt(arr[0]) == 0)
			answer += 0;
		else
			for (int i = 0; i < numbers.length; i++)
				answer += arr[i];

		return answer;
	}

}
