package d3;

import java.util.Arrays;
import java.util.Scanner;

public class Problem7087 {

	// 7087. 문제 제목 붙이기
	public static void main(String[] args) {

		// Scanner 생성
		Scanner scan = new Scanner(System.in);

		// 테스트 케이스 개수 입력
		int testCase = scan.nextInt();

		// 입력한 개수만큼 반복
		for (int test = 1; test <= testCase; test++) {

			// 제목 개수 입력
			int N = scan.nextInt();
			// 제목 앞 글자만 저장하는 배열
			char[] firstTitle = new char[N];

			// 배열에 제목 앞 글자만 저장
			for (int i = 0; i < N; i++) {
				String str = scan.next();
				firstTitle[i] = str.charAt(0);
			}

			// 배열 정렬
			Arrays.sort(firstTitle);

			// 사용 가능한 제목 개수를 저장할 변수
			int count = 0;

			// 맨 앞이 A여야 시작 가능
			if (firstTitle[0] == 'A') {

				// 일단 A가 있으므로 1 추가
				count++;

				for (int i = 1; i < N; i++) {

					// 동일한 제목이 연속이면 건너뛰기
					if (firstTitle[i] == firstTitle[i - 1]) {
						continue;
					} else if (firstTitle[i] - 1 == firstTitle[i - 1]) {
						// 연속 글자면 count 1 추가
						count++;
					} else {
						// 연속 글자, 동일 글자가 아니면 더이상 제목 사용 불가
						break;
					}
				}

			}

			// 결과 출력
			System.out.println("#" + test + " " + count);

		}

		// Scanner 종료
		scan.close();

	}

}
