package d3;

import java.util.Scanner;

public class Problem10726 {

	// 10726. 이진수 표현
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);

		int testCase = scan.nextInt();

		for (int test = 1; test <= testCase; test++) {
			// 탐색하려는 비트 개수
			int N = scan.nextInt();
			// 대상 숫자
			int M = scan.nextInt();

			// 탐색하려는 비트를 모두 1로 채우기
			int X = (1 << N) - 1;

			// AND 연산자로 해당 칸이 모두 1로 채워져있는지 여부에 따라 결과 출력
			if ((M & X) == X) {
				System.out.println("#" + test + " ON");
			} else {
				System.out.println("#" + test + " OFF");
			}
		}

		scan.close();
	}

}
