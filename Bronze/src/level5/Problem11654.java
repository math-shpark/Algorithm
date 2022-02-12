package level5;

import java.util.Scanner;

public class Problem11654 {

	// 11654. 아스키 코드
	public static void main(String[] args) {

		// Scanner 생성
		Scanner scan = new Scanner(System.in);

		// 문자열 입력
		String str = scan.next();

		// String을 char로 변환
		char a = str.charAt(0);

		// int 형으로 출력하여 아스키 코드 획득
		System.out.println((int) a);

		// Scanner 종료
		scan.close();

	}

}
