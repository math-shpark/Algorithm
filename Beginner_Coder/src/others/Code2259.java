package others;

import java.util.Scanner;

public class Code2259 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int s = scan.nextInt(); // standard count

		int[][] arr = new int[6][2];

		int w, h, wIdx, hIdx;
		w = 0;
		h = 0;
		wIdx = 0;
		hIdx = 0;

		for (int i = 0; i < 6; i++) {
			arr[i][0] = scan.nextInt();
			arr[i][1] = scan.nextInt();

			if (arr[i][0] == 1 || arr[i][0] == 2) {
				if (arr[i][1] > w) {
					w = arr[i][1];
					wIdx = i;
				}
			} else {
				if (arr[i][1] > h) {
					h = arr[i][1];
					hIdx = i;
				}
			}
		}

		int area = w * h;
		int x, y;

		if ((wIdx + 1) % 6 == hIdx) {
			x = arr[(wIdx + 4) % 6][1];
			y = arr[(hIdx + 2) % 6][1];
		} else {
			x = arr[(wIdx + 2) % 6][1];
			y = arr[(hIdx + 4) % 6][1];
		}

		area -= x * y;

		System.out.println(area * s);
	}

}
