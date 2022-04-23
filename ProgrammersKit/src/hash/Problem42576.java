package hash;

import java.util.Arrays;

public class Problem42576 {

	// 완주하지 못한 선수
	public static void main(String[] args) {

		String[] participant = { "mislav", "stanko", "mislav", "ana" };
		String[] completion = { "stanko", "ana", "mislav" };

		String answer = solution(participant, completion);

		System.out.println(answer);

	}

	private static String solution(String[] participant, String[] completion) {
		String answer = "";

		Arrays.sort(participant);
		Arrays.sort(completion);
		int idx = -1;

		for (int i = 0; i < completion.length; i++) {
			if (!completion[i].equals(participant[i])) {
				idx = i;
				break;
			}
		}

		answer = idx == -1 ? participant[participant.length - 1] : participant[idx];

		return answer;
	}

}
