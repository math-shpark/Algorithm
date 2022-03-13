package level4;

import java.util.Scanner;

public class Problem17626 {

	// 17626. Four Squares
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// n입력
		int n = scan.nextInt();
		// 숫자별 제곱수 개수를 저장할 변수
		int[] square = new int[n + 1];

		// 1은 제곱수 1개이므로 1 저장
		square[1] = 1;

		// 2부터 n까지 필요한 제곱수 개수를 구한 후 배열에 저장하는 반복문
		for (int i = 2; i <= n; i++) {
			// 최소 제곱수 개수를 저장할 변수
			int min = n;

			// square 배열에서 인덱스가 제곱수이면 1이 저장되고
			// 제곱수가 아니면 제곱수를 기준으로 n에서 제곱수를 뺀 후 남은 수에서 필요한 제곱수 개수를 구하고
			// 그 중 최소 개수를 min에 저장하는 반복문
			for (int j = 1; j * j <= i; j++) {
				if (square[i - j * j] < min) {
					min = square[i - j * j];
				}
			}
			// 특정 제곱수를 기준으로 해당 제곱수를 제외하고 필요한 제곱수 개수가 min이므로
			// 특정 제곱수까지 포함하기 위해 1을 더함
			square[i] = min + 1;
		}

		// 결과 출력
		System.out.println(square[n]);

		scan.close();

	}

}
