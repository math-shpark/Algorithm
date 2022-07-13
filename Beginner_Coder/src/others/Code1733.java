package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Code1733 {
	static int[] dr = { 1, 1, 1, 0 };
	static int[] dc = { -1, 0, 1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[][] map = new char[19][19];

		for (int i = 0; i < 19; i++) {
			map[i] = br.readLine().replace(" ", "").toCharArray();
		}

		int win = 0;

		Outer: for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				if (map[i][j] == '0')
					continue;

				for (int k = 0; k < 4; k++) {
					int count = 0;

					for (int b = 0; b < 5; b++) {
						int X = i + dc[k] * b;
						int Y = j + dr[k] * b;
						if (X < 0 || Y < 0 || X >= 19 || Y >= 19)
							break;
						if (map[i][j] != map[X][Y])
							break;
						count++;

						if (count == 5) {
							X = i - dc[k];
							Y = j - dr[k];
							if (X >= 0 && Y >= 0 && X < 19 && Y < 19) {
								if (map[i][j] == map[X][Y])
									break;
							}

							X = i + dc[k] * 5;
							Y = j + dr[k] * 5;
							if (X >= 0 && Y >= 0 && X < 19 && Y < 19) {
								if (map[i][j] == map[X][Y])
									break;
							}
							win = map[i][j] - '0';
							System.out.println(win);
							System.out.println((i + 1) + " " + (j + 1));
							break Outer;
						}

					}
				}
			}
		}
		if (win == 0)
			System.out.println(win);
		br.close();

	}
}
