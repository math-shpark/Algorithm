package level1;

import java.util.Scanner;

public class Problem1074 {

	static int N, r, c, order;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		// 크기 입력
		N = scan.nextInt();
		// 찾을 행, 열의 위치 입력
		r = scan.nextInt();
		c = scan.nextInt();

		// 찾는 재귀 함수 실행
		search((int) Math.pow(2, N), 0, 0);

		scan.close();
	}

	// 순서를 찾는 재귀함수
	static void search(int n, int x, int y) {
		// 기본
		// 찾으면 순서 출력 후 반환
		if (x == r && y == c) {
			System.out.println(order);
			return;
		}

		// 재귀
		// 찾으려는 위치가 설정한 범위 내면 재귀 함수를 실행하고
		if (x <= r && r < (x + n) && y <= c && c < (y + n)) {
			int half = n / 2;

			// 설정한 범위를 4등분하여
			// 해당 범위 안에 드는지 재귀함수 실행
			search(half, x, y);
			search(half, x, y + half);
			search(half, x + half, y);
			search(half, x + half, y + half);
		} else
			// 해당 범위에 없으면 해당 범위의 크기 다음 순번이므로
			// count 변수에 해당 크기를 더함
			order += n * n;
	}

}
