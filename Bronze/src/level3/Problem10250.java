package level3;

import java.util.Scanner;

public class Problem10250 {

	// 10250. ACM 호텔
	public static void main(String[] args) {

		// Scanner 생성
		Scanner scan = new Scanner(System.in);

		// 테스트 케이스 개수 입력
		int testCase = scan.nextInt();

		// 테스트 케이스별 결과 출력 반복문
		for (int i = 0; i < testCase; i++) {
			// 높이
			int h = scan.nextInt();
			// 너비
			int w = scan.nextInt();
			// 손님 순번
			int n = scan.nextInt();

			// 층
			int floor = n % h;
			// 방 번호
			int room = n / h;

			// 꼭대기 층일 경우
			if (floor == 0) {
				System.out.println(h * 100 + room);
			} else {
				System.out.println(floor * 100 + room + 1); // 나머지
			}
		}

		scan.close();

	}

}
