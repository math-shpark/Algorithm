package sort;

import java.util.Arrays;

public class Problem42747 {

	public static void main(String[] args) {
		int[] citations = { 3, 0, 6, 1, 5 };

		int answer = solution(citations);

		System.out.println(answer);
	}

	private static int solution(int[] citations) {
		int answer = 0;

		Arrays.sort(citations);

		if (citations[0] >= citations.length)
			answer = citations.length;
		else {
			Outer: while (true) {
				for (int i = 0; i < citations.length; i++) {
					if (citations[i] >= answer) {
						if ((citations.length - i) >= answer && citations[citations.length - answer - 1] <= answer)
							break Outer;
						else {
							answer++;
							break;
						}
					}
				}
			}
		}

		return answer;
	}

}
