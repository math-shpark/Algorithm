package level1;

import java.util.Scanner;

public class Problem2748 {

	// 2748. 피보나치 수 2
	public static void main(String[] args) {

		// Scanner 생성
		Scanner scan = new Scanner(System.in);

		// 순번 입력값 저장
		int num = scan.nextInt();

		// 뒷 순번의 피보나치 값이 크므로 long 타입으로 배열 생성
		long[] arr = new long[num + 1];

		// 0번째 값 입력
		arr[0] = 0;
		// 입력값이 1이상일 경우 1번째 값 입력
		if (num > 0) {
			arr[1] = 1;
		}

		// 피보나치 수열 식을 반복문으로 표현
		for (int i = 2; i <= num; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
		}

		// 결과 출력
		System.out.println(arr[num]);

		// 종료
		scan.close();

	}

}
