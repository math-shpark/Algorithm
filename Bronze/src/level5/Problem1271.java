package level5;

import java.math.BigInteger;
import java.util.Scanner;

public class Problem1271 {

	// 1271. 엄청난 부자 2
	public static void main(String[] args) {

		// Scanner 생성
		Scanner scan = new Scanner(System.in);

		// 조교가 가진 돈
		BigInteger money = scan.nextBigInteger();
		// 돈을 받고 싶은 생명체 수
		BigInteger life = scan.nextBigInteger();

		// 한 생명체 당 받는 돈 출력
		System.out.println(money.divide(life));
		// 돈을 나눠주고 남은 돈 출력
		System.out.println(money.remainder(life));

		scan.close();

	}

}
