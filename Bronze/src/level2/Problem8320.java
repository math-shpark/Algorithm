package level2;

import java.util.Scanner;

public class Problem8320 {

	// 8320. 직사각형을 만드는 방법
	public static void main(String[] args) {

		// Scanner 생성
		Scanner scan = new Scanner(System.in);

		// 정사각형의 개수 입력
		int n = scan.nextInt();
		// 만들 수 있는 직사각형의 수를 저장할 변수
		int count = 0;

		// 만들 수 있는 직사각형의 개수를 세는 반복문
		// 행의 길이 1부터 만들 수 있는 직사각형의 개수를 셈
		// 열의 길이는 행의 길이보다 같거나 커야 회전해도 다른 직사각형이 됨
		for (int i = 1; i <= n; i++) {
			for (int j = i; j <= n; j++) {
				if (i * j <= n) {
					count++;
				}
			}
		}

		// 결과 출력
		System.out.println(count);

		// Scanner 종료
		scan.close();

	}

}
