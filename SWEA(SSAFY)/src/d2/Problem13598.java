package d2;

import java.util.Scanner;

public class Problem13598 {

	// 13598. Gravity
	public static void main(String[] args) {
		// Scanner 생성
		Scanner scan = new Scanner(System.in);

		// 박스 사이즈 저장
		int boxSize = scan.nextInt();
		// 박스별 높이를 저장할 배열 생성
		int[] height = new int[boxSize];
		// 낙차를 저장할 배열 생성
		int[] dropHeight = new int[boxSize];

		// 박스별 높이를 배열에 저장
		for (int i = 0; i < boxSize; i++) {
			height[i] = scan.nextInt();
		}
		// 낙차를 구해서 배열에 저장하는 반복문
		for (int i = 0; i < boxSize; i++) {
			// 자신을 기준으로 우측에
			// 자신보다 높거나 같게 쌓인 박스의 개수를 저장하는 변수
			int count = 0;
			// 자신 우측에 자신보다 높거나 같게 쌓인 박스의 개수를 구하는 반복문
			for (int j = i + 1; j < boxSize; j++) {
				if (height[i] <= height[j]) {
					count++;
				}
			}
			// 낙차는 자신의 위치에서 박스 끝까지의 거리에서 앞서 센 박스의 개수를 뺀 것
			dropHeight[i] = boxSize - 1 - i - count;
		}
		// 낙차 최댓값을 저장할 변수
		int max = 0;
		// 낙차 값을 저장한 배열에서 최댓값을 찾아 저장
		for (int i = 0; i < boxSize; i++) {
			if (max < dropHeight[i]) {
				max = dropHeight[i];
			}
		}
		// 최댓값을 출력
		System.out.println(max);
		scan.close();
	}

}
