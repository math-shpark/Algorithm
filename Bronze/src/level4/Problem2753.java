package level4;

import java.util.Scanner;

public class Problem2753 {

	// 2753. 윤년
	public static void main(String[] args) {

		// Scanner 생성
		Scanner scan = new Scanner(System.in);

		// 연도 입력
		int year = scan.nextInt();

		// 윤년 조건 만족 여부에 따라 출력값 결정
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
		
		// 종료
		scan.close();

	}

}
