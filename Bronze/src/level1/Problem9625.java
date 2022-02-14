package level1;

import java.util.Scanner;

public class Problem9625 {

	// 9625. BABBA
	public static void main(String[] args) {

		// Scanner 생성
		Scanner scan = new Scanner(System.in);
		// 버튼 누를 횟수
		int k = scan.nextInt();

		// A와 B의 개수를 저장할 배열
		int[] countA = new int[46];
		int[] countB = new int[46];

		// 버튼 누른 횟수와 인덱스를 맞추기 위해 0번 인덱스는 모두 0으로 입력
		countA[0] = 0;
		countA[1] = 0;
		countA[2] = 1;

		countB[0] = 0;
		countB[1] = 1;
		countB[2] = 1;

		// A와 B의 개수는 피보나치 수열의 규칙으로 늘어남
		// 피보나치 수열 규칙에 따라 반복하는 반복문
		for (int i = 3; i <= 45; i++) {
			countA[i] = countA[i - 1] + countA[i - 2];
			countB[i] = countB[i - 1] + countB[i - 2];
		}

		// 결과 출력
		System.out.println(countA[k] + " " + countB[k]);

		// Scanner 종료
		scan.close();

	}

}
