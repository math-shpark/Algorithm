package level2;

import java.util.Scanner;

public class Problem2675 {

	// 2675. 문자열 반복
	public static void main(String[] args) {

		// Scanner 생성
		Scanner scan = new Scanner(System.in);

		// 테스트 케이스 입력 값 저장
		int testCase = scan.nextInt();

		// 문자열별 반복 횟수를 저장할 배열 생성
		int[] arr1 = new int[testCase];
		// 문자열별 글자를 개별 저장한 값을 저장할 배열 생성
		String[][] arr2 = new String[testCase][];

		for (int i = 0; i < testCase; i++) {
			// 반복 횟수 입력값 저장
			int repeat = scan.nextInt();
			// 문자열 입력값 저장
			String str = scan.next();

			// 입력한 반복 횟수 배열에 저장
			arr1[i] = repeat;
			// 입력한 문자열 배열에 저장
			arr2[i] = str.split("");
		}

		// 테스트 케이스만큼 반복
		for (int i = 0; i < testCase; i++) {
			
			// 입력한 문자열의 길이만큼 반복
			for (int j = 0; j < arr2[i].length; j++) {
				
				// 입력한 반복횟수만큼 문자별로 반복
				for (int k = 0; k < arr1[i]; k++) {
					System.out.print(arr2[i][j]);
				}
				
			}
			
			// 한 줄 간격
			System.out.println();
			
		}

		// 끝내기
		scan.close();

	}

}
