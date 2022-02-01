package level1;

import java.util.Scanner;

public class Problem2851 {

	// 2851. 슈퍼마리오
	public static void main(String[] args) {

		// Scanner 생성
		Scanner scan = new Scanner(System.in);

		// 입력받은 값을 저장할 배열 생성
		int[] num = new int[10];

		// 입력받은 값을 배열에 저장하는 반복문
		for (int i = 0; i < 10; i++) {
			num[i] = scan.nextInt();
		}

		// 입력한 값을 더한 값을 저장할 변수
		int sum = 0;

		// 100까지의 거리가 적은 쪽을 선택하는 반복문
		for (int i = 0; i < 10; i++) {
			if (Math.abs(100 - sum) >= Math.abs(100 - (sum + num[i]))) {
				sum += num[i];
			} else {
				break; // 더하지 않으면 반복문 종료
			}
		}

		// 결과 출력
		System.out.println(sum);
		
		// 끝내기
		scan.close();
	}

}
