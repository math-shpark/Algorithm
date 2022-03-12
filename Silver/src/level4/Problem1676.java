package level4;

import java.math.BigInteger;
import java.util.Scanner;

public class Problem1676 {

	// 1676. 팰토리얼 0의 개수
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		// N 입력
		int N = scan.nextInt();
		// 팩토리얼 값을 저장할 변수
		BigInteger p = new BigInteger("1");

		// 팩토리얼을 계산하는 반복문
		for (int i = 1; i <= N; i++) {
			p = p.multiply(new BigInteger("" + i + ""));
		}

		// 0의 개수를 저장할 변수
		int count = 0;

		// 팩토리얼 결과를 문자열로 변환
		String pStr = String.valueOf(p);

		// 뒤에서부터 0의 개수를 확인하며
		// 0이 아니면 반복문 종료
		for (int i = pStr.length() - 1; i >= 0; i--) {
			if (pStr.charAt(i) == '0') {
				count++;
			} else {
				break;
			}
		}
		// 결과 출력
		System.out.println(count);

		scan.close();
	}

}
