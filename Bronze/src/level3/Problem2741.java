package level3;

import java.util.Scanner;

public class Problem2741 {

	// 2741. N 찍기
	public static void main(String[] args) {

		// Scanner 생성
		Scanner scan = new Scanner(System.in);

		// 출력 제한 범위 입력 저장
		int num = scan.nextInt();

		// 하나씩 증가하며 출력하는 반복문
		for (int i = 1; i <= num; i++) {
			System.out.println(i);
		}

		// 끝내기
		scan.close();

	}

}
