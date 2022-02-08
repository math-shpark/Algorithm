package level1;

import java.util.Scanner;

public class Problem2839 {

	// 2839. 설탕 배달
	public static void main(String[] args) {

		// Scanner 생성
		Scanner scan = new Scanner(System.in);

		// 목표 설탕 무게
		int sugar = scan.nextInt();
		// 설탕 봉지의 개수
		int count = 0;

		// 목표 무게에 5를 나눈 몫을 봉지 개수에 추가
		count += sugar / 5;
		// 남은 설탕의 무게
		sugar -= count * 5;

		// 남은 설탕의 무게가 3으로 나누어지지 않으면
		// 5kg 설탕 봉지 1개를 줄이고 3으로 나누어지는지 확인하는 반복문
		while (true) {

			// 5kg 봉지가 남아있고 3kg 봉지로 맞출 수 없는 경우
			if (count != 0 && sugar % 3 != 0) {

				count -= 1;
				sugar += 5;

			} // 남은 무게를 3kg 봉지로 맞출 수 있는 경우
			else if (sugar % 3 == 0) {
				count += sugar / 3;
				System.out.println(count);
				break;
			} // 5kg 봉지가 남아있지 않고 3kg로도 무게를 맞출 수 없는 경우
			else {
				System.out.println(-1);
				break;
			}

		}
		// 종료
		scan.close();

	}

}
