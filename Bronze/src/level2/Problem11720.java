package level2;

import java.util.Scanner;

public class Problem11720 {

	// 11720. 숫자의 합
	public static void main(String[] args) {

		// Scanner 생성
		Scanner scan = new Scanner(System.in);

		// 입력하는 숫자의 개수
		int count = scan.nextInt();
		// 입력라인 전체를 문자열로 입력
		String numStr = scan.next();
		// 한자리씩 잘라 배열에 저장
		String[] numStrArr = numStr.split("");

		// 합을 저장할 변수
		int sum = 0;

		// 각 자리별 문자열을 int형으로 변환하여 덧셈
		for (int i = 0; i < count; i++) {
			sum += Integer.parseInt(numStrArr[i]);
		}

		// 결과 출력
		System.out.println(sum);

		// Scanner 종료
		scan.close();

	}

}
