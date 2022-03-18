package d3;

import java.util.Scanner;

public class Problem1289 {

	// 1289. 원재의 메모리 복구하기
	public static void main(String[] args) {

		// Scanner 생성
		Scanner scan = new Scanner(System.in);

		// 테스트 케이스 개수 입력
		int testCase = scan.nextInt();

		// 입력한 개수만큼 반복
		for (int test = 1; test <= testCase; test++) {
			// 원래 메모리 입력
			String original = scan.next();
			// 변환 횟수 저장 변수
			int count = 0;
			// 원래 메모리를 저장할 배열
			int[] originalArr = new int[original.length()];

			// 원래 매모리를 배열에 저장하는 반복문
			for (int i = 0; i < original.length(); i++) {
				originalArr[i] = original.charAt(i) - '0';
			}

			// 초기화된 데이터를 저장할 배열
			int[] newArr = new int[originalArr.length];

			// 맨 앞자리부터 변환을 시작하는 반복문
			for (int i = 0; i < newArr.length; i++) {

				// 다를 경우만 변환하여 최소로 변환하도록 조건 설정
				if (originalArr[i] != newArr[i]) {
					for (int j = i; j < newArr.length; j++) {
						newArr[j] = originalArr[i];
					}
					// 변환 횟수 1 증가
					count++;
				}
			}
			// 결과 출력
			System.out.println("#" + test + " " + count);

		}

		// Scanner 종료
		scan.close();

	}

}
