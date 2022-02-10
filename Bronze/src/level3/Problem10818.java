package level3;

import java.util.Scanner;

public class Problem10818 {

	// 10818. 최소, 최대
	public static void main(String[] args) {

		// Scanner 생성
		Scanner scan = new Scanner(System.in);

		// 숫자의 개수 입력
		int numData = scan.nextInt();

		// 최솟값 저장 변수
		int max = -1000000;
		// 최댓값 저장 변수
		int min = 1000000;

		// 입력받은 숫자들이 최대인지, 최소인지 판별 후
		// 해당 변수에 저장하는 반복문
		for (int i = 0; i < numData; i++) {
			int num = scan.nextInt();

			if (max < num) {
				max = num;
			}

			if (min > num) {
				min = num;
			}
		}

		// 결과 출력
		System.out.println(min + " " + max);

		// Scanner 종료
		scan.close();

	}

}
