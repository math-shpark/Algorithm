package level1;

import java.util.Scanner;

public class Problem1652 {

	// 1652. 누울 자리를 찾아라
	public static void main(String[] args) {

		// Scanner 생성
		Scanner scan = new Scanner(System.in);

		// 공간 사이즈 입력
		int size = scan.nextInt();
		// 공간 배열 생성
		int[][] space = new int[size][size];
		// 90도 회전 공간 배열 생성
		int[][] space2 = new int[size][size];

		// 공간 배열에 데이터를 입력하는 반복문
		for (int i = 0; i < size; i++) {
			String str = scan.next();

			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) == 'X') {
					space[i][j] = 1;
					space2[j][i] = 1;
				}
			}
		}

		// 자리 개수 세는 메소드 활용
		int countRow = countArea(size, space);
		int countCol = countArea(size, space2);

		// 결과 출력
		System.out.println(countRow + " " + countCol);

		// Scanner 종료
		scan.close();

	}

	// 자리를 찾는 메소드
	public static int countArea(int size, int[][] space) {

		// 자리 개수를 저장할 변수
		int count = 0;

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size - 1; j++) {
				if (space[i][j] == 0 && space[i][j + 1] == 0) {
					count++;
					// 두자리 확보가 되면 벽 또는 짐에 도달할 때까지 이동
					while (space[i][j + 1] != 1) {
						j++;

						// 벽에 도달하면 반복문 종료
						if (j == size - 1) {
							break;
						}
					}
				}
			}
		}

		// 자리 개수 반환
		return count;
	}

}
