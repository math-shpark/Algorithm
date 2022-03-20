package level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1780 {

	// 0 종이 개수
	static int countOne = 0;
	// 1 종이 개수
	static int countZero = 0;
	// -1 종이 개수
	static int countMinus = 0;
	// 공간 정보 배열
	static int[][] space;

	// 1780. 종이의 개수
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 공간 크기 입력
		int N = Integer.parseInt(br.readLine());
		// 배열 크기 지정
		space = new int[N][N];

		StringTokenizer st;

		// 공간 정보 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				space[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 재귀함수 실행
		makePaper(0, 0, N);

		// 결과 출력
		System.out.println(countMinus);
		System.out.println(countZero);
		System.out.println(countOne);

	}

	private static void makePaper(int startX, int startY, int range) {

		// 시작 위치의 번호 저장
		int startNum = space[startX][startY];
		// 색종이 가능 여부를 저장할 변수
		boolean isOkay = true;

		// 각 위치를 돌면서 숫자가 시작 위치와 동일한지 판별하는 반복문
		for (int i = startX; i < startX + range; i++) {
			for (int j = startY; j < startY + range; j++) {
				if (space[i][j] != startNum) {
					isOkay = false;
				}
			}
		}

		// 가능하면 시작 위치의 번호에 따라 종이의 개수를 추가
		if (isOkay) {
			switch (startNum) {
			case 0:
				countZero++;
				return;
			case 1:
				countOne++;
				return;
			case -1:
				countMinus++;
				return;
			}
		} else {
			// 종이로 만들 수 없는 경우
			// 9등분하여 재귀함수 실행
			makePaper(startX, startY, range / 3);
			makePaper(startX, startY + range / 3, range / 3);
			makePaper(startX, startY + (range / 3) * 2, range / 3);
			makePaper(startX + range / 3, startY, range / 3);
			makePaper(startX + range / 3, startY + range / 3, range / 3);
			makePaper(startX + range / 3, startY + (range / 3) * 2, range / 3);
			makePaper(startX + (range / 3) * 2, startY, range / 3);
			makePaper(startX + (range / 3) * 2, startY + range / 3, range / 3);
			makePaper(startX + (range / 3) * 2, startY + (range / 3) * 2, range / 3);
		}

	}

}
