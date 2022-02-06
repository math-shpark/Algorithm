package level3;

import java.util.Scanner;

public class Problem2742 {

	// 2741. 기찍 N
	public static void main(String[] args) {

		// Scanner 생성
		Scanner scan = new Scanner(System.in);

		// 출력 제한 범위 입력 저장
		int num = scan.nextInt();

		// 하나씩 감소하며 출력하는 반복문
		for (int i = num; i > 0; i--) {
			System.out.println(i);
		}

		// 끝내기
		scan.close();

	}

}
