package level2;

import java.util.Scanner;

public class Problem3040 {

	// 선택할 숫자들을 저장할 배열
	static int[] numArr = new int[9];
	// 선택한 숫자를 저장할 배열
	static int[] selected = new int[7];

	// 3040. 백설공주와 일곱 난쟁이
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// 배열의 숫자 정보 입력
		for (int i = 0; i < 9; i++) {
			numArr[i] = scan.nextInt();
		}

		// 조합 메소드 실행
		combination(0, 0);

		scan.close();

	}

	// 조합
	private static void combination(int start, int count) {

		// 경계
		// 7명을 다 뽑았을 경우 재귀 종료
		if (count == 7) {
			// 뽑은 난쟁이의 번호를 더할 변수
			int sum = 0;

			// 번호 합 계산
			for (int num : selected) {
				sum += num;
			}

			// 번호 합이 딱 100이면 현재 뽑은 7명의 번호를 출력
			if (sum == 100) {
				for (int num : selected) {
					System.out.println(num);
				}
			}
			
			return;
		}

		// 재귀
		for (int i = start; i < 9; i++) {
			selected[count] = numArr[i];
			combination(i + 1, count + 1);
		}

	}

}
