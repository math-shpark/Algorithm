package level5;

import java.math.BigInteger;
import java.util.Scanner;

public class Problem2338 {

	// 2338. 긴자리 계산
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		BigInteger A = scan.nextBigInteger();
		BigInteger B = scan.nextBigInteger();

		System.out.println(A.add(B));
		System.out.println(A.subtract(B));
		System.out.println(A.multiply(B));
		
		scan.close();

	}

}
