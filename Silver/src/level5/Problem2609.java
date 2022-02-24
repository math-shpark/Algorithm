package level5;

import java.util.Scanner;

public class Problem2609 {

	// 2609. 최대공약수와 최소공배수
	public static void main(String[] args) {

		// Scanner 생성
		Scanner scan = new Scanner(System.in);

		// 두 개의 수 입력
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();

		// 최대공약수
		int gcd = 1;

		// 최대공약수를 찾는 반복문
		for (int i = Math.min(num1, num2); i > 0; i--) {
			if (num1 % i == 0 && num2 % i == 0) {
				gcd = i;
				break;
			}
		}

		// 최대공약수 출력
		System.out.println(gcd);

		// 최소공배수
		int lcm = 1;

		// 첫 번째 수를 최대 공약수로 나눈 몫
		int q1 = num1 / gcd;
		// 두 번째 수를 최대 공약수로 나눈 몫
		int q2 = num2 / gcd;

		// 최소공배수를 구하는 식
		lcm = gcd * q1 * q2;

		// 최소공배수 출력
		System.out.println(lcm);

		// Scanner 종료
		scan.close();

	}

}
