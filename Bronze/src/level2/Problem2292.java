package level2;

import java.util.Scanner;

public class Problem2292 {

	// 2292. 벌집
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// 목표 숫자 입력
		int num = scan.nextInt();

		// 입력 숫자가 1이면 1을 출력하고 메소드 종료
		if (num == 1) {
			System.out.println(1);
			return;
		}

		// 거리를 저장할 변수
		int distance = 1;
		// 동일한 거리의 숫자들 중 최솟값을 저장할 변수
		int minNum = 2;

		// 거리 원이 입력한 숫자를 넘어가기 전까지 반복
		while (minNum <= num) {
			// 동일한 거리의 숫자의 개수가 6의 배수로 늘어남
			minNum = minNum + (6 * distance);
			distance++;
		}

		// 결과 출력
		System.out.println(distance);

		// Scanner 종료
		scan.close();

	}

}
