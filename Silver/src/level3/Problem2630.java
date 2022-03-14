package level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2630 {

	// 색종이 정보를 저장할 배열
	static int[][] space;
	// 흰색 색종이 수를 저장할 변수
	static int countWhite = 0;
	// 파란색 색종이 수를 저장할 변수
	static int countBlue = 0;

	// 2630. 색종이 만들기
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 공간 크기 입력
		int N = Integer.parseInt(br.readLine());
		// 입력한 크기에 맞춰 배열 크기 지정
		space = new int[N][N];

		// 배열에 공간 정보 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				space[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 정해진 규칙을 수행하는 재귀함수 실행
		// 매개변수 1 : 탐색 범위
		// 매개변수 2 : 시작 지점 행 좌표
		// 매개변수 3 : 시작 지점 열 좌표
		makePaper(N, 0, 0);

		// 결과 출력
		System.out.println(countWhite);
		System.out.println(countBlue);

	}

	private static void makePaper(int N, int startX, int startY) {

		// 시작 지점이 어떤 색인지 저장
		int num = space[startX][startY];
		// 해당 범위로 색종이를 만들 수 있는지 여부를 저장할 변수
		boolean isOkay = true;

		Outer: for (int i = startX; i < startX + N; i++) {
			for (int j = startY; j < startY + N; j++) {
				// 시작 지점이랑 색이 다른 좌표를 찾으면
				if (num != space[i][j]) {
					// 색종이를 만들 수 없음을 표시하고
					isOkay = false;
					// 반복문 종료
					break Outer;
				}
			}
		}

		// 해당 범위로 색종이를 만들 수 있으면
		if (isOkay) {
			// 시작 지점의 색이 곧 종이의 색이므로
			// 해당 값에 맞춰 개수를 1 추가하고
			if (num == 1) {
				countBlue++;
			} else {
				countWhite++;
			}
			// 재귀 종료
			return;
		} else {
			// 해당 범위로 색종이를 만들 수 없으면
			// 정해진 규칙에 따라 4등분하여 각 범위별 좌측 상단을 시작점으로 하여 재귀 실행
			makePaper(N / 2, startX, startY);
			makePaper(N / 2, startX + N / 2, startY);
			makePaper(N / 2, startX, startY + N / 2);
			makePaper(N / 2, startX + N / 2, startY + N / 2);
		}

	}

}
