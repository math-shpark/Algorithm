package sort;

import java.util.Arrays;

public class Problem42748 {

	public static void main(String[] args) {

		int[] array = { 1, 5, 2, 6, 3, 7, 4 };
		int[][] commands = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };

		int[] answer = solution(array, commands);

		System.out.println(Arrays.toString(answer));

	}

	private static int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];

		for (int r = 0; r < commands.length; r++) {
			int i = commands[r][0] - 1;
			int j = commands[r][1] - 1;
			int k = commands[r][2] - 1;

			int[] sortArr = new int[j - i + 1];

			for (int c = i; c <= j; c++) {
				sortArr[c - i] = array[c];
			}

			Arrays.sort(sortArr);

			answer[r] = sortArr[k];
		}

		return answer;
	}

}
