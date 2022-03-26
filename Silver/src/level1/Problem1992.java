package level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Problem1992 {

	// 영상 정보를 저장할 배열
	static int[][] space;
	// 압축 결과를 입력할 큐
	static Queue<String> result = new LinkedList<String>();

	// 1992. 쿼드트리
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 영상 공간 크기 입력
		int N = Integer.parseInt(br.readLine());

		// 배열 크기 지정
		space = new int[N][N];

		// 영상 정보 입력
		for (int i = 0; i < N; i++) {
			String str = br.readLine();

			for (int j = 0; j < N; j++) {
				space[i][j] = str.charAt(j) - '0';
			}
		}

		// 재귀함수 실행
		makeZip(0, 0, N);

		// 결과 출력
		while (!result.isEmpty()) {
			sb.append(result.poll());
		}

		System.out.println(sb);

	}

	// 분할 재귀함수
	private static void makeZip(int startX, int startY, int range) {

		// 출발점의 영상 정보 입력
		int startNum = space[startX][startY];
		// 압축 가능 여부를 저장할 변수
		boolean isOkay = true;

		// 압축 가능 여부를 탐색하는 반복문
		Outer: for (int i = startX; i < startX + range; i++) {
			for (int j = startY; j < startY + range; j++) {
				if (space[i][j] != startNum) {
					isOkay = false;
					break Outer;
				}
			}
		}

		// 압축이 가능하면 해당 숫자를 큐에 입력
		if (isOkay) {
			result.add(String.valueOf(startNum));
		} else {
			// 압축이 불가하면 괄호를 추가하고
			// 괄호 안에 4등분하여 재귀함수 호출
			result.add("(");
			makeZip(startX, startY, range / 2);
			makeZip(startX, startY + range / 2, range / 2);
			makeZip(startX + range / 2, startY, range / 2);
			makeZip(startX + range / 2, startY + range / 2, range / 2);
			result.add(")");
		}

	}

}
