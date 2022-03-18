package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1954 {

	// 1954. 달팽이 숫자
	public static void main(String[] args) throws NumberFormatException, IOException {

		// 입력 스트림 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트 케이스 개수 입력
		int testCaseNum = Integer.parseInt(br.readLine());

		// 입력한 개수만큼 반복
		for (int test = 1; test <= testCaseNum; test++) {

			// 배열 사이즈 입력
			int N = Integer.parseInt(br.readLine());
			// 입력한 사이즈에 맞춰 배열 생성
			int[][] space = new int[N][N];

			// 칸에 입력할 값
			int value = 1;
			// 한 줄에 입력할 칸의 개수
			int fillBlock = N;
			// 배열에 값을 입력할 곳의 인덱스
			int row = 0;
			int col = 0;

			// 입력할 칸의 개수가 0이 될 때까지 무한 반복
			while (fillBlock > 0) {

				// 오른쪽으로 채우기
				for (int i = 0; i < fillBlock; i++) {
					space[row][col++] = value++;
				}

				fillBlock--;
				col--;
				row++;

				// 아래쪽으로 채우기
				for (int i = 0; i < fillBlock; i++) {
					space[row++][col] = value++;
				}

				row--;
				col--;

				// 왼쪽으로 채우기
				for (int i = 0; i < fillBlock; i++) {
					space[row][col--] = value++;
				}

				fillBlock--;
				col++;
				row--;

				// 위쪽으로 채우기
				for (int i = 0; i < fillBlock; i++) {
					space[row--][col] = value++;
				}

				row++;
				col++;

			}

			// 출력 양식
			System.out.println("#" + test);

			// 결과 출력
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(space[i][j] + " ");
				}
				System.out.println();
			}

		}

	}

}
