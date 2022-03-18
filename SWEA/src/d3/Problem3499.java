package d3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem3499 {

	// 3499. 퍼펙트 셔플
	public static void main(String[] args) {

		// Scanner 생성
		Scanner scan = new Scanner(System.in);

		// 테스트 케이스 개수 입력
		int testCase = scan.nextInt();

		// 입력한 개수만큼 반복
		for (int test = 1; test <= testCase; test++) {

			// 문자열의 개수
			int N = scan.nextInt();
			// 문자열의 앞 절반을 저장할 배열
			String[] first = new String[(N + 1) / 2];
			// 문자열의 뒤 절반을 저장할 배열
			String[] second = new String[N / 2];

			// 앞 배열에 문자열 입력
			for (int i = 0; i < first.length; i++) {
				first[i] = scan.next();
			}

			// 뒤 배열에 문자열 입력
			for (int i = 0; i < second.length; i++) {
				second[i] = scan.next();
			}

			// 셔플할 큐
			Queue<String> shuffle = new LinkedList<String>();

			// 퍼펙트 셔플 규칙에 맞춰 큐에 문자열 추가
			for (int i = 0; i < second.length; i++) {
				shuffle.add(first[i]);
				shuffle.add(second[i]);
			}

			// N이 홀수인 경우 first에 하나 남은 문자열 마저 추가
			if (N % 2 == 1) {
				shuffle.add(first[first.length - 1]);
			}

			// 다 넣은 상태의 큐 길이
			int size = shuffle.size();

			// 출력 양식
			System.out.print("#" + test);

			// 하나씩 꺼내며 출력
			for (int i = 0; i < size; i++) {

				System.out.print(" " + shuffle.remove());

			}

			// 줄 바꿈
			System.out.println();

		}

		// Scanner 종료
		scan.close();

	}

}
