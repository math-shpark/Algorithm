package d2;

import java.util.Scanner;

public class Problem1926 {

	// 1926. 간단한 369 게임
	public static void main(String[] args) {

		// Scanner 생성
		Scanner scan = new Scanner(System.in);

		// 숫자 범위 입력
		int N = scan.nextInt();

		// 해당 숫자까지 게임하는 반복문
		for (int i = 1; i <= N; i++) {
			// 숫자를 문자열로 입력
			String str = String.valueOf(i);
			// 3, 6, 9의 개수를 저장할 변수
			int count = 0;

			// 각 자리에 3, 6, 9의 개수를 세는 반복문
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) == '3' || str.charAt(j) == '6' || str.charAt(j) == '9') {
					count++;
				}
			}

			// 3, 6, 9 가 하나도 없으면 원래 값 출력
			if (count == 0) {
				System.out.print(i + " ");
			} else {
				// 하나라도 있으면 개수만큼 -를 출력한 후
				for (int j = 0; j < count; j++) {
					System.out.print("-");
				}
				// 공백 출력
				System.out.print(" ");
			}
		}

		// Scanner 종료
		scan.close();

	}

}
