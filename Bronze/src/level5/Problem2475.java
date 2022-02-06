package level5;

import java.util.Scanner;

public class Problem2475 {

	// 2475. 검증수
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("고유번호 앞 5자리를 입력하세요.");

		// 입력한 5자리 숫자를 저장할 배열
		int[] nums = new int[5];

		// 입력한 숫자를 배열에 저장
		for (int i = 0; i < nums.length; i++) {
			nums[i] = scan.nextInt();
		}

		// 합을 저장할 변수
		double sum = 0;

		// 각 자리 숫자를 제곱한 후 더함
		for (int num : nums) {
			sum += Math.pow(num, 2);
		}
		
		// 6번째 숫자를 저장할 변수 선언 및 대입
		int lastNum = (int) (sum % 10);
		
		// 결과 출력
		System.out.println(lastNum);
		
		// 스캔 종료
		scan.close();

	}

}
