package level3;

import java.util.Arrays;
import java.util.Scanner;

public class Problem4153 {

	// 4153. 직각삼각형
	public static void main(String[] args) {

		// Scanner 생성
		Scanner scan = new Scanner(System.in);

		// 0 입력 전까지 무한 반복
		while (true) {

			// 입력한 변의 길이 저장 배열
			int[] side = new int[3];

			// 입력 값 배열에 저장
			for (int i = 0; i < 3; i++) {
				side[i] = scan.nextInt();
			}

			// 입력 값이 0이면 반복문 종료
			if (side[0] == 0) {
				break;
			}

			// 오름차순으로 정렬
			Arrays.sort(side);

			// 피타고라스 공식 적용
			if (Math.pow(side[2], 2) == Math.pow(side[0], 2) + Math.pow(side[1], 2)) {
				System.out.println("right");
			} else {
				System.out.println("wrong");
			}

		}

		// Scanner 종료
		scan.close();

	}

}
