package level1;

import java.util.Scanner;

public class Problem2869 {

	// 2869. 달팽이는 올라가고 싶다
	public static void main(String[] args) {

		// Scanner 생성
		Scanner scan = new Scanner(System.in);

		// 올라가는 높이
		int up = scan.nextInt();
		// 미끄러지는 높이
		int down = scan.nextInt();
		// 나무 막대기 길이
		int height = scan.nextInt();

		// 올라간 기간
		int day = (height - down) / (up - down);

		// 나머지가 있을 경우
		if ((height - down) % (up - down) != 0) {
			day++;
		}

		// 결과 출력
		System.out.println(day);

		// 끝내기
		scan.close();

	}

}