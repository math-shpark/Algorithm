package level3;

import java.util.Scanner;

public class Problem1085 {

	// 1085. 직사각형에서 탈출
	public static void main(String[] args) {

		// Scanner 생ㅅ어
		Scanner scan = new Scanner(System.in);

		// 좌표 및 범위 입력
		int x = scan.nextInt();
		int y = scan.nextInt();
		int w = scan.nextInt();
		int h = scan.nextInt();

		// 가로 방향 최단 거리
		int minX = Math.min(x, w - x);
		// 세로 방향 최단 거리
		int minY = Math.min(y, h - y);

		// 가로, 세로 최단 거리의 최단 거리
		System.out.println(Math.min(minX, minY));

		scan.close();

	}

}
