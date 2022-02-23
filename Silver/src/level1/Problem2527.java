package level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2527 {

	// 2527. 직사각형
	public static void main(String[] args) throws IOException {

		// 입력 스트림 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 4번 테스트 케이스 반복
		for (int test = 0; test < 4; test++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			int[] rect1X = new int[2]; // 첫번째 직사각형의 x
			int[] rect1Y = new int[2]; // 첫번째 직사각형의 y
			int[] rect2X = new int[2]; // 두번째 직사각형의 x
			int[] rect2Y = new int[2]; // 두번째 직사각형의 y

			// 첫 번째 사각형 좌표 입력
			for (int i = 0; i < 2; i++) {
				rect1X[i] = Integer.parseInt(st.nextToken());
				rect1Y[i] = Integer.parseInt(st.nextToken());
			}

			// 두 번째 사각형 좌표 입력
			for (int i = 0; i < 2; i++) {
				rect2X[i] = Integer.parseInt(st.nextToken());
				rect2Y[i] = Integer.parseInt(st.nextToken());
			}

			// 공통 부분이 없는 경우
			if ((rect1X[0] > rect2X[1]) || (rect1X[1] < rect2X[0]) || (rect1Y[0] > rect2Y[1])
					|| (rect1Y[1] < rect2Y[0])) {
				System.out.println('d');
			} else if ((rect1X[0] == rect2X[1] && rect1Y[0] == rect2Y[1])
					|| (rect1X[1] == rect2X[0] && rect1Y[1] == rect2Y[0])
					|| (rect1X[0] == rect2X[1] && rect1Y[1] == rect2Y[0])
					|| (rect1X[1] == rect2X[0] && rect1Y[0] == rect2Y[1])) {
				// 점으로 만나는 경우
				// 점으로 만나는 경우는 꼭짓점만 가능하므로
				// 꼭짓점만 비교하면 됨
				System.out.println('c');
			} else if ((rect1X[0] == rect2X[1]) || (rect1X[1] == rect2X[0]) || (rect1Y[0] == rect2Y[1])
					|| (rect1Y[1] == rect2Y[0])) {
				// 선분으로 만나는 경우
				// 꼭짓점에서 걸러졌는데도 만나는 것은 선분이나 직사각형
				// 한 사각형의 시작점과 나머지 사각형의 끝점이 같으면 선분
				System.out.println('b');
			} else {
				// 나머지는 모두 직사각형
				System.out.println('a');
			}
		}
	}

}
