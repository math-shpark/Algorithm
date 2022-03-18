package d2;

import java.util.Scanner;

public class Problem1288 {

	// 1288. 새로운 불면증 치료법
	public static void main(String[] args) {

		// Scanner 생성
		Scanner scan = new Scanner(System.in);

		// 테스트 케이스 개수 입력
		int testCase = scan.nextInt();

		// 입력한 개수만큼 반복
		for (int test = 1; test <= testCase; test++) {

			// 배수를 취할 숫자 입력
			int N = scan.nextInt();
			// 각 숫자별 출현 여부를 저장할 배열 생성
			int[] count = new int[10];
			// 배수
			int multiple = 1;

			// 0부터 9까지 모두 나올 때까지 무한 반복
			while (true) {

				// 배수 값을 문자열로 받음
				String num = String.valueOf(N * multiple);

				// 문자열로 받은 배수 값의 각 자리 숫자를
				// 인덱스로 받아 해당 위치에 1을 입력
				for (int i = 0; i < num.length(); i++) {
					count[num.charAt(i) - '0'] = 1;
				}

				// 각 인덱스별 데이터 합을 저장할 변수
				int sum = 0;

				// 각 인덱스별 데이터 합을 구하는 반복문
				for (int i = 0; i < 10; i++) {
					sum += count[i];
				}

				// 모든 숫자가 나와서 합이 10이면 반복문 종료
				if (sum == 10) {
					break;
				} else {
					multiple++;
				}

			}

			// 결과 출력
			System.out.println("#" + test + " " + N * multiple);

		}

		// Scanner 종료
		scan.close();

	}

}
