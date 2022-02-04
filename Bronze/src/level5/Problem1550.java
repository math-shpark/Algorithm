package level5;

import java.util.Scanner;

public class Problem1550 {

	// 1550. 16진수
	public static void main(String[] args){

		// Scanner 생성
		Scanner scan = new Scanner(System.in);

		// 입력값을 String 타입으로 받기
		String num = scan.next();

		// 입력받은 String 타입 수를 16진수의 수로 읽어 10진수로 변환
		int num2 = Integer.parseInt(num, 16);

		// 결과 출력
		System.out.print(num2);

		// 끝내기
		scan.close();

	}

}
