package level4;

import java.util.Scanner;

public class Problem2477 {

	// 2477. 참외밭
	public static void main(String[] args) {

		// Scanner 생성
		Scanner scan = new Scanner(System.in);

		// 단위 면적 당 자라는 과일의 개수
		int fruit = scan.nextInt();
		// 밭 면적을 저장할 변수
		int area = 0;
		// 밭의 변의 길이를 저장할 배열
		int[] length = new int[6];
		// 연속되는 두 변을 곱한 값들을 더할 변수
		int sum = 0;
		// 가로 최장 길이
		int hMax = 0;
		// 세로 최장 길이
		int vMax = 0;

		// 밭의 변의 길이를 배열에 저장하고
		for (int i = 0; i < 6; i++) {
			int direction = scan.nextInt();
			length[i] = scan.nextInt();

			// 가로 최장 길이와
			if (direction == 1 || direction == 2) {
				if (hMax < length[i]) {
					hMax = length[i];
				}
			}
			// 세로 최장 길이를 저장하는 반복문
			else {
				if (vMax < length[i]) {
					vMax = length[i];
				}
			}
		}

		// 제외되는 면적까지 포함한 총 넓이
		area = hMax * vMax;

		// 붙어 있는 두 변을 곱해서 생기는 넓이를
		// sum 변수에 모두 더함
		for (int i = 0; i < 6; i++) {
			if (i == 5) {
				sum += length[i] * length[0];
			} else {
				sum += length[i] * length[i + 1];
			}
		}

		// 붙어 있는 두 변을 곱해서 모두 더하면
		// 파인 부분을 제외하고 모두 3번씩 넓이가 더해지고
		// 파인 부분만 한 번 덜 더해진 값을 얻을 수 있음
		// 따라서 파인 부분은 총 면적을 3배 한 후 sum에 저장된 값을 빼서 얻는 값
		area = area - (area * 3 - sum);

		// 결과 출력
		System.out.println(area * fruit);

		// Scanner 종료
		scan.close();

	}

}