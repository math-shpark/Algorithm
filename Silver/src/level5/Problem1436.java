package level5;

import java.util.Scanner;

public class Problem1436 {

	// 1436. 영화감독 숌
	public static void main(String[] args) {

		// Scanner 생성
		Scanner scan = new Scanner(System.in);

		// 입력 받을 횟수
		int N = scan.nextInt();
		// 개수를 저장할 변수
		int i = 0;
		// 답을 저장할 변수
		int num = 100;

		Outer: while (true) {

			// 숫자를 문자열로 입력
			String str = String.valueOf(num);

			// 종말 숫자의 조건을 만족하면
			// 개수를 저장하는 변수에 1을 추가하고
			// 개수를 저장한 변수의 값과 원하는 횟수가 동일하면 반복문을 종료하고
			// 해당 숫자를 반환
			for (int j = 0; j < str.length() - 2; j++) {
				if (str.charAt(j) == '6' && str.charAt(j + 1) == '6' && str.charAt(j + 2) == '6') {

					i++;

					if (i == N) {
						break Outer;
					}

					break;
				}
			}

			num++;

		}

		// 결과 출력
		System.out.println(num);

		// Scanner 종료
		scan.close();

	}

}
