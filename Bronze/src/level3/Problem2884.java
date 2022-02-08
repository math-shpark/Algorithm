package level3;

import java.util.Scanner;

public class Problem2884 {

	// 2884. 알람 시계
	public static void main(String[] args) {

		// Scanner 생성
		Scanner scan = new Scanner(System.in);

		// 시간 입력
		int hour = scan.nextInt();
		// 분 입력
		int min = scan.nextInt();

		// 분이 45분보다 작으면 시간에서 1시간 뺀 후 분에 15분 더함
		if (min < 45) {
			hour -= 1;
			min += 15; // 60분을 더한 후 45분을 빼면 15분이 남음
		} else {
			min -= 45; // 분이 45분보다 크면 분에서만 45분 차감
		}

		// 00시에서 1시간을 빼서 -1이 되면 23시이므로 23 입력
		if (hour == -1) {
			hour = 23;
		}

		// 결과 출력
		System.out.println(hour + " " + min);

		// 종료
		scan.close();

	}

}
