package level5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem9663 {

	// 체스판
	// 인덱스는 말이 놓일 열 번호
	// 배열 안에 저장되는 값은 말의 행 번호
	public static int[] space;
	// 체스판의 크기
	public static int N;
	// 가능한 경우의 수
	public static int result = 0;

	// 9663. N-Queen
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 크기 입력
		N = Integer.parseInt(br.readLine());
		// 배열 크기 입력
		space = new int[N];

		// 순열
		permutation(0);
		
		// 결과 출력
		System.out.println(result);

	}

	// 퀸 말을 놓는 재귀함수
	// 매개변수 : 현재까지 놓은 퀸 말의 개수
	public static void permutation(int count) {
		// 경계
		// 적절한 위치에 퀸을 놓는 것이 완료되면
		if (count == N) {
			// 경우의 수에 1 추가한 후
			result++;
			// 재귀 종료
			return;
		}

		// 재귀
		for (int i = 0; i < N; i++) {
			// 제일 윗 줄부터 넣어보면서
			space[count] = i;
			// 놓을 수 있는 위치일 경우 재귀
			if (isOkay(count)) {
				permutation(count + 1);
			}
		}

	}

	// 퀸 말을 놓을 수 있는지 여부를 판단하는 메서드
	// 매개변수 : 열 번호
	public static boolean isOkay(int col) {

		for (int i = 0; i < col; i++) {
			// 놓으려는 행의 위치가
			// 현재 열보다 왼쪽 열에서 이미 말이 존재하면
			if (space[col] == space[i]) {
				// 불가
				return false;
			} else if (Math.abs(col - i) == Math.abs(space[col] - space[i])) {
				// 행은 다르지만
				// 이전 열에 놓인 말의 대각선 방향에 위치하면
				// 불가
				return false;
			}
		}

		// 위의 경우에서 걸리지 않으면 가능
		return true;
	}

}
