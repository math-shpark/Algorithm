package search;

import java.util.Arrays;

public class Problem42840 {

	public static void main(String[] args) {
		int[] answers = { 1, 3, 2, 4, 2 };
		int[] answer = solution(answers);

		System.out.println(Arrays.toString(answer));
	}

	private static int[] solution(int[] answers) {
		int[][] ansArr = { { 1, 2, 3, 4, 5 }, { 2, 1, 2, 3, 2, 4, 2, 5 }, { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 } };
		int[] scores = new int[3];
		int maxScore = 0;
		int size = 0;

		for (int i = 0; i < 3; i++) {
			int score = 0;
			for (int j = 0; j < answers.length; j++) {
				if (answers[j] == ansArr[i][j % ansArr[i].length]) {
					score++;
				}
			}
			if (maxScore < score) {
				maxScore = score;
				size = 1;
			} else if (maxScore == score) {
				size++;
			}
			scores[i] = score;
		}

		int[] answer = new int[size];

		for (int i = 0, idx = 0; i < 3; i++) {
			if (scores[i] == maxScore) {
				answer[idx] = i + 1;
				idx++;
			}
		}

		return answer;
	}

}
