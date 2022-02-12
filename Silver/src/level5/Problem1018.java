package level5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Problem1018 {

	// 1018. 체스판 다시 칠하기
	public static void main(String[] args) {

		// Scanner 생성
		Scanner scan = new Scanner(System.in);

		// 공간 크기 입력
		int row = scan.nextInt();
		int col = scan.nextInt();

		// 입력받은 크기에 맞춰 배열 생성
		Boolean[][] space = new Boolean[row][col];

		// 입력값에 따라 참, 거짓값으로 배열에 저장
		// W : true
		// B : false
		for (int i = 0; i < row; i++) {
			String str = scan.next();

			for (int j = 0; j < col; j++) {
				if (str.charAt(j) == 'W') {
					space[i][j] = true;
				} else {
					space[i][j] = false;
				}
			}
		}

		// 이동 가능한 거리 인덱스
		int rowMove = row - 7;
		int colMove = col - 7;

		// 각 위치별 칠해야 하는 칸의 개수를 저장하는 리스트
		List<Integer> countList = new ArrayList<>();

		// count 메소드를 활용하여 좌표별 칠해야 하는 칸의 개수 리스트에 저장
		for (int i = 0; i < rowMove; i++) {
			for (int j = 0; j < colMove; j++) {
				countList.add(count(i, j, space));
			}
		}

		// 오름차순으로 정렬
		Collections.sort(countList);

		// 0번 인덱스를 출력하여 최솟값 출력
		System.out.println(countList.get(0));

		// Scanner 종료
		scan.close();
	}

	// 좌표별 칠해야 하는 칸의 개수를 반환하는 메소드
	static int count(int x, int y, Boolean[][] space) {

		// 입력 좌표 기준 체스판 범위
		int rightEnd = x + 8;
		int bottomEnd = y + 8;
		// 칠해야 하는 칸의 개수를 저장할 변수
		int count = 0;
		// 시작 좌표의 색
		Boolean startColor = space[x][y];

		// 색이 번갈아가는지 여부에 따라 count에 1 추가
		for (int i = x; i < rightEnd; i++) {
			for (int j = y; j < bottomEnd; j++) {

				if (space[i][j] != startColor) {
					count++;
				}

				startColor = !startColor;

			}
			startColor = !startColor;
		}

		// 색이 맞지 않다고 확인한 칸을 칠하는 개수와
		// 맞다고 확인된 칸을 다시 칠하는 개수 중
		// 최솟값을 저장
		count = Math.min(count, 64 - count);

		return count;
	}

}
