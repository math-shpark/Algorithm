package level1;

import java.util.Arrays;

public class Problem92334 {

	// 92334. 신고 결과 받기
	public static void main(String[] args) {

		// 매개변수
		String[] id_list = { "muzi", "frodo", "apeach", "neo" };
		String[] report = { "muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi" };
		int k = 2;

		int[] answer = solution(id_list, report, k);

		System.out.println(Arrays.toString(answer));

	}

	public static int[] solution(String[] id_list, String[] report, int k) {
		int[] answer = new int[id_list.length];
		int[][] call = new int[id_list.length][id_list.length];
		int[] count = new int[id_list.length];

		for (int i = 0; i < report.length; i++) {
			String[] input = report[i].split(" ");
			String p1 = input[0];
			String p2 = input[1];

			int idx1 = -1;
			int idx2 = -1;

			for (int j = 0; j < id_list.length; j++) {
				if (p1.equals(id_list[j]))
					idx1 = j;

				if (p2.equals(id_list[j]))
					idx2 = j;
			}

			if (call[idx1][idx2] == 0)
				count[idx2]++;
			call[idx1][idx2] = 1;
		}

		for (int i = 0; i < id_list.length; i++) {
			for (int j = 0; j < id_list.length; j++) {
				if (call[i][j] == 1 && count[j] >= k) {
					answer[i]++;
				}
			}
		}
		return answer;
	}

}
