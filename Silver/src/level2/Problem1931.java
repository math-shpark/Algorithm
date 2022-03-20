package level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Problem1931 {

	// 1931. 회의실 배정
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		int[][] meeting = new int[N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			meeting[i][0] = start;
			meeting[i][1] = end;
		}

		Arrays.sort(meeting, new Comparator<int[]>() {

			@Override
			public int compare(int[] a1, int[] a2) {
				if (a1[1] == a2[1]) {
					return a1[0] - a2[0];
				}

				return a1[1] - a2[1];
			}
		});

		int count = 0;
		int previousMeeting = 0;

		for (int i = 0; i < N; i++) {
			if (previousMeeting <= meeting[i][0]) {
				previousMeeting = meeting[i][1];
				count++;
			}
		}

		System.out.println(count);

	}

}
