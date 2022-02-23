package level5;

import java.util.Scanner;

public class Problem2578 {

	// 2578. 빙고
	public static void main(String[] args) {

		// Scanner 생성
		Scanner scan = new Scanner(System.in);

		// 빙고판 생성
		int[][] space = new int[5][5];
		// 사회자가 부를 순번 저장
		int order = 0;

		// 빙고판 숫자 정보 저장
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				space[i][j] = scan.nextInt();
			}
		}

		// 빙고를 부를 때까지 반복
		for (int i = 1; i <= 25; i++) {
			// 빙고 개수를 저장할 변수
			int count = 0;
			// 사회자가 부를 숫자
			int call = scan.nextInt();

			// 사회자가 부른 칸은 0으로 표시
			for (int j = 0; j < 5; j++) {
				for (int k = 0; k < 5; k++) {
					if (space[j][k] == call) {
						space[j][k] = 0;
					}
				}
			}

			// 각 방향별 메소드를 활용하여 빙고 개수 확인
			count += rowCheck(space);
			count += colCheck(space);
			count += diagonalRightCheck(space);
			count += diagonalLeftCheck(space);

			// 빙고가 3개 이상이면
			// 현재 부른 순번을 저장하고 반복 종료
			if (count >= 3) {
				order = i;
				break;
			}

		}

		// 결과 출력
		System.out.println(order);

		// Scanner 종료
		scan.close();

	}

	// 가로 방향 체크
	public static int rowCheck(int[][] space) {
		int count = 0;

		for (int i = 0; i < 5; i++) {
			int temp = 0;

			for (int j = 0; j < 5; j++) {
				if (space[i][j] == 0) {
					temp++;
				}
			}

			if (temp == 5) {
				count++;
			}
		}

		return count;
	}

	// 세로 방향 체크
	public static int colCheck(int[][] space) {
		int count = 0;

		for (int i = 0; i < 5; i++) {
			int temp = 0;

			for (int j = 0; j < 5; j++) {
				if (space[j][i] == 0) {
					temp++;
				}
			}

			if (temp == 5) {
				count++;
			}
		}

		return count;
	}

	// 우하방향 체크
	public static int diagonalRightCheck(int[][] space) {
		int count = 0;
		int temp = 0;

		for (int i = 0; i < 5; i++) {

			if (space[i][i] == 0) {
				temp++;
			}

			if (temp == 5) {
				count++;
			}
		}

		return count;
	}

	// 좌하방향 체크
	public static int diagonalLeftCheck(int[][] space) {
		int count = 0;
		int temp = 0;

		for (int i = 0; i < 5; i++) {

			if (space[i][4 - i] == 0) {
				temp++;
			}

			if (temp == 5) {
				count++;
			}
		}

		return count;
	}

}
