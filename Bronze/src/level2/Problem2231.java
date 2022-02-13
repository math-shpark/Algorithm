package level2;

import java.util.Scanner;

public class Problem2231 {

	// 2231. 분해합
	public static void main(String[] args) {

		// Scanner 생성
		Scanner scan = new Scanner(System.in);

		// 데이터 입력
		int num = scan.nextInt();

		// 최소 생성자 저장 변수
		int con = 1;

		// 최소 생성자를 찾을 때까지 무한 반복
		while (true) {

			// 최소 생성자가 없는 경우
			if (con >= num) {
				System.out.println(0);
				break;
			}

			// 생성자인지 판별할 숫자를 문자열로 변환
			String conStr = String.valueOf(con);

			// 분해합을 저장할 변수
			int newNum = con;

			// 분해합을 하는 반복문
			for (int i = 0; i < conStr.length(); i++) {
				newNum += (int) conStr.charAt(i) - 48;
			}

			// 생성자가 맞으면 출력
			if (newNum == num) {
				System.out.println(con);
				break;
			} else {
				con++; // 아니면 다음 숫자로 반복문 실행
			}

		}

		// Scanner 종료
		scan.close();

	}

}
